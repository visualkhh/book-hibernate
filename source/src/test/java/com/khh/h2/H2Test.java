package com.khh.h2;


import org.h2.tools.Console;
import org.h2.tools.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.SQLException;
import java.util.Date;

//@Slf4j
public class H2Test {
	private static final Logger log = LoggerFactory.getLogger(H2Test.class);










	@Before
	public void before(){
	}

	@Test
	public void test() throws SQLException, InterruptedException {
//		Server server = Server.createTcpServer("jdbc:h2:~/test").start();
//		Server webServer = Server.createWebServer("-web,-webAllowOthers,true,-webPort,8082").start();
		Server server = Server.createTcpServer("-tcpPort" ,"9092", "-tcpAllowOthers").start();
//		Server server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8088").start();
//		Server server = Server.createWebServer("-web",  "-webPort", "8088").start();
//		Server server = Server.createPgServer().start();
		Console console = new Console();
//		console.runTool("-url","jdbc:h2:mem:test","-user","sa","-password","","-tool","-tcp","-tcpPort","9092");
		console.runTool();
//		console.runTool("-tool");
//		console.runTool("-help");
		log.debug (server.getURL());
//		Server.createWebServer("-webPort", "8082", "-tcpAllowOthers")
//		Server server = Server.createTcpServer("-tcp","-tcpAllowOthers","true","-tcpPort","9092").start();

		Thread.sleep(1000000000);
	}

	@After
	public void after(){

	}
}
