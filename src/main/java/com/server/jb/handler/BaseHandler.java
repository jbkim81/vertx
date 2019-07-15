package com.server.jb.handler;

import org.springframework.context.ApplicationContext;

import io.vertx.core.Context;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public abstract class BaseHandler<T> implements Handler<Message<T>> {
	
	protected ApplicationContext context;
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected Vertx vertx;
	protected EventBus eb =null;
	public BaseHandler () {
		
	}
	
	public BaseHandler(ApplicationContext context, Vertx vertx) {
		this.context = context;
		this.vertx = vertx;
		this.eb = this.vertx.eventBus();
	}
	@Override
	public void handle(Message<T> message) {
		// TODO Auto-generated method stub
		logger.debug(message.body());

		Context ctx = vertx.getOrCreateContext();
		System.out.println(Thread.currentThread() + ":" + ctx.isWorkerContext());
		
		vertx.executeBlocking(future->{
			try {
				System.out.println(Thread.currentThread() + ":" + ctx.isWorkerContext());
				
				process(message);
				future.complete();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				future.fail(e);
			}
		}, ar-> {
			if ( ar.failed() )
				ar.cause().printStackTrace();
		});
	}
	
	/**
	 * <pre>
	 * 1. 개요:
	 * 2. 처리내용:
	 *</pre>
	 * @Method Name: process
	 * @param message
	 * @throws Exception
	 */
	public abstract void process(Message<T> message) throws Exception; 
}
