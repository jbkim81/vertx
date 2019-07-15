package com.server.jb.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;

import org.reflections.Reflections;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class VertXServer extends AbstractVerticle {
	
	public static Set<Class<?>> annotatedClass;
	private int port;
	private static int vertXport;
	private static boolean useSessionManager = false;
	private boolean isSessionManager = false;
	private static int redisPort;
	private static String redisIp;
	private static String fileStorage;
	public static String getFileStorage() {
		return fileStorage;
	}

//	public static void setFileStorage(String fileStorage) {
//		VertXServer.fileStorage = fileStorage;
//	}

	public static void main(String[] args) {
		try {
			loadConfig(args);
			Reflections reflections = new Reflections("com.server.jb.handler");
			annotatedClass = reflections.getTypesAnnotatedWith((Class<? extends Annotation>) Verticle.class);
			Vertx serverM = Vertx.vertx(new VertxOptions().setEventLoopPoolSize(8).setWorkerPoolSize(8));
			serverM.deployVerticle(new VertXServer(vertXport, useSessionManager));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static void loadConfig(String[] args) throws Exception {
		// TODO Auto-generated method stub
	  try {
			Properties prop = new Properties();
			String configFile = "config/websocket.properties";
			System.out.println(Paths.get(configFile).toAbsolutePath().toString());
			InputStream is = new FileInputStream(Paths.get(configFile).toFile());
			prop.load(is);
			is.close();
			vertXport = Integer.parseInt(prop.getProperty("vertXport"));
			redisPort = Integer.parseInt(prop.getProperty("redisPort"));
			redisIp = prop.getProperty("redisIp").trim();
			fileStorage = prop.getProperty("fileStorage").trim();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public VertXServer(int port, boolean useSessionManager) {
		this.port = port;
		this.isSessionManager = useSessionManager;
	}
	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		super.start();
		Router router = Router.router(vertx);
		
		router.route().handler(BodyHandler.create().setUploadsDirectory(fileStorage));
		
	}
 
}
