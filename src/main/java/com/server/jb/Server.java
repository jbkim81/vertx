package com.server.jb;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class Server extends AbstractVerticle {

	private static String filestorage;
	private static int vertxport;
	private static int webport;
	private static int redisport;
	
	public static void main(String[] args) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
  @Override
  public void start() {
//    vertx
//        .createHttpServer()
//        .requestHandler(r -> {
//          r.response().end("<h1>Hello Vert.x 3 application</h1>");
//        })
//        .listen(8080);
	  Router router = Router.router(vertx);
	  router.route().handler(BodyHandler.create().setUploadsDirectory(filestorage));
	  
  }
}
