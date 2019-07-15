package com.server.jb;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.logging.Logger;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetSocket;

public class Server extends AbstractVerticle {

//	private static String filestorage;
//	private static int vertxport;
//	private static int webport;
//	private static int redisport;
	private Logger logger; 
 
  @Override
  public void start() {
//	    vertx
//        .createHttpServer()
//        .requestHandler(r -> {
//          r.response().end("<h1>Hello Vert.x 3 application</h1>");
//        })
//        .listen(8080);
    NetServer netserver = vertx.createNetServer();
    netserver.connectHandler(new Handler<NetSocket>() {
		
		@Override
		public void handle(NetSocket socket) {
			// TODO Auto-generated method stub
			socket.handler(new Handler<Buffer>(){

				@Override
				public void handle(Buffer buff) {
					// TODO Auto-generated method stub
					System.out.println("receive data: "+ buff.toString());
//					System.out.println("receive data: "+ buff.toString());
				}
			});
			
			socket.closeHandler(new Handler<Void>(){
				@Override
				public void handle(Void event) {
					// TODO Auto-generated method stub
//					System.out.println("connetion close: "+socket.remoteAddress());
					System.out.println("connetion close: "+socket.remoteAddress());
				}
			});
			
			socket.exceptionHandler(new Handler<Throwable>() {

				@Override
				public void handle(Throwable throwable) {
					// TODO Auto-generated method stub
					System.out.println("unexpected exception: " + throwable);
				}
			});
			socket.write("hello world!!");
		}
	});
  
//	  Router router = Router.router(vertx);
//	  router.route().handler(BodyHandler.create().setUploadsDirectory(filestorage));
    netserver.listen(8090,"localhost");
    
  }
}
