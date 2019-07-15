package com.server.jb.handler;

import org.springframework.context.ApplicationContext;
import com.server.jb.annotation.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.Message;

//@Verticle(value = BizWorksDataVerticle.class, eventbus="websocket.selectMessageAction")
public class test<T> extends BaseHandler<T> {

	public test(ApplicationContext context, Vertx vertx) {
		// TODO Auto-generated constructor stub
		super(context, vertx);
	}
	@Override
	public void process(Message<T> message) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
