//package com.khh.h2;
//
//import org.h2.tools.RunScript;
//import org.h2.tools.Server;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.persistence.Embedded;
//import javax.sql.DataSource;
//import java.io.File;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//
//public class H2Server extends Server{
//	public static final String DB_TYPE_FILE = "file";
//	Logger log = LoggerFactory.getLogger(this.getClass());
//
//	List<File> scripts = null;
//	/*
//		Database URLs
//
//		Embedded
//		jdbc:h2:~/test 'test' in the user home directory
//		jdbc:h2:/data/test 'test' in the directory /data
//		jdbc:h2:test in the current(!) working directory
//
//		In-Memory
//		jdbc:h2:mem:test multiple connections in one process
//		jdbc:h2:mem: unnamed private; one connection
//
//		Server Mode
//		jdbc:h2:tcp://localhost/~/test user home dir
//		jdbc:h2:tcp://localhost//data/test absolute dir
//		Server start:java -cp *.jar org.h2.tools.Server
//
//		Settings
//		jdbc:h2:..;MODE=MySQL compatibility (or HSQLDB,...)
//		jdbc:h2:..;TRACE_LEVEL_FILE=3 log to *.trace.db
//	 */
//
////	@Override
////	public int start() {
////		int rint = super.start();
////		executeScript();
////		return rint;
////	}
//
//
//	@Override
//	public Server start() throws SQLException {
//		return super.start();
//	}
//
//	public void executeScript() throws SQLException {
////		DriverManager.registerDriver(new org.h2.Driver());
////		Connection c = DriverManager.getConnection("jdbc:h2:mem:test");
////		PreparedStatement stmt = c.prepareStatement("CREATE TABLE PERSON (ID INT PRIMARY KEY, FIRSTNAME VARCHAR(64), LASTNAME VARCHAR(64))");
////		stmt.execute();
////		stmt.close();
////		c.close();
//		for (File script : scripts) {
//			this.getURL()
//			RunScript.execute();
//		}
//
//	}
//	public H2Server addScript(File file){
//		if(null==this.scripts){
//			this.scripts = new ArrayList<File>();
//		}
//		this.scripts.add(file);
//		return this;
//	}
//	public H2Server setScript(List<File> files){
//		this.scripts = files;
//		return this;
//	}
//	public H2Server setScript(File[] files){
//		this.scripts = Arrays.asList(files);
//		return this;
//	}
//}
