package com.khh.hibernate;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.sf.corn.cps.CPScanner;
import net.sf.corn.cps.ClassFilter;
import org.h2.tools.RunScript;
import org.h2.tools.Server;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Slf4j
public abstract class HibernateSet implements Runnable{
	//private static final Logger log = LoggerFactory.getLogger(HibernateSet.class);//
	private SessionFactory sessionFactory = null;
	private List<String> resource = new ArrayList<>();
	public HibernateSet(List<String> resource){
		this.resource = resource;
		init();
	}
	public HibernateSet(){
		init();
	}

	private void init(){
		try {
			log.debug(this.getClass().getPackage().getName());

			//H2 Database Start
			//https://techdev.de/querying-the-embedded-h2-database-of-a-spring-boot-application/
			//http://www.h2database.com/html/features.html#connection_modes
			/*
				$ java -cp /opt/h2/bin/h2.jar org.h2.tools.Server -help
				Starts the H2 Console (web-) server, TCP, and PG server.
				Usage: java org.h2.tools.Server
				When running without options, -tcp, -web, -browser and -pg are started.
				Options are case sensitive. Supported options are:
				[-help] or [-?]         Print the list of options
				[-web]                  Start the web server with the H2 Console
				[-webAllowOthers]       Allow other computers to connect - see below
				[-webPort ]       The port (default: 8082)
				[-webSSL]               Use encrypted (HTTPS) connections
				[-browser]              Start a browser and open a page to connect to the web server
				[-tcp]                  Start the TCP server
				[-tcpAllowOthers]       Allow other computers to connect - see below
				[-tcpPort ]       The port (default: 9092)
				[-tcpSSL]               Use encrypted (SSL) connections
				[-tcpPassword ]    The password for shutting down a TCP server
				[-tcpShutdown ""]  Stop the TCP server; example: tcp://localhost:9094
				[-tcpShutdownForce]     Do not wait until all connections are closed
				[-pg]                   Start the PG server
				[-pgAllowOthers]        Allow other computers to connect - see below
				[-pgPort ]        The port (default: 5435)
				[-baseDir ]        The base directory for H2 databases; for all servers
				[-ifExists]             Only existing databases may be opened; for all servers
				[-trace]                Print additional trace information; for all servers
			 */
//			Server server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8088").start();
			Server server = Server.createTcpServer("-tcpPort" ,"9092", "-tcpAllowOthers").start();

			//HibernateSet ConfigSetting
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.addPackage(this.getClass().getPackage().getName());

			//https://sites.google.com/site/javacornproject/corn-cps
			List<Class<?>> classes = CPScanner.scanClasses(new ClassFilter().packageName(this.getClass().getPackage().getName() + "*").annotation(Entity.class));
			for (Class<?> clazz : classes) {
				log.debug("add Annotation "+clazz);
				configuration.addAnnotatedClass(clazz);
			}

			resource.forEach(it->configuration.addResource(it));

			String url = configuration.getProperties().getProperty(Environment.URL);
			String user = configuration.getProperties().getProperty(Environment.USER);
			String pass = configuration.getProperties().getProperty(Environment.PASS);
			log.debug("url:{} user:{} pass:{}",url,user,pass);
			URL resource = Thread.currentThread().getContextClassLoader().getResource("schema.sql");

			Class.forName ("org.h2.Driver");
			Connection conn = DriverManager.getConnection (url, user,pass);


			if(null!=resource) {
				RunScript.execute(conn, new FileReader(resource.getPath()));
			}

			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());

			resource = Thread.currentThread().getContextClassLoader().getResource("data.sql");
			if(null!=resource) {
				RunScript.execute(conn, new FileReader(resource.getPath()));
//				RunScript.execute(conn, new File(resource.getFile()).getAbsolutePath(), StandardCharsets.UTF_8, true);
			}
		}catch (Exception e){
			log.error("init",e);
		}
	}


	public String makeGQuery(String template, Map<String, Object> o) throws ScriptException {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("groovy");
		StringBuffer t = new StringBuffer();
		t.append("def engine = new groovy.text.SimpleTemplateEngine(false);");
		t.append("  def template = engine.createTemplate(template);");
		t.append("  def binding = [");
		String commaSeparatedNumbers = (String)o.entrySet().stream().map((at) -> {
			Object val = at.getValue();
			if(at.getValue() != null && String.class.isAssignableFrom(val.getClass())) {
				val = "'''" + val.toString() + "'''";
			}

			return val == null?(String)at.getKey() + ":null":(String)at.getKey() + ":" + val.toString() + "";
		}).collect(Collectors.joining(", "));
		t.append(commaSeparatedNumbers);
		t.append("];");
		log.debug("Groovy Template-->"+t);
		engine.put("template", template);
		return (String)engine.eval(t + " template.make(binding).toString();");
	}
}
