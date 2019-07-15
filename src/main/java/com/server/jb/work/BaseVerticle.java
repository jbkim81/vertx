package com.server.jb.work;

import org.springframework.context.ApplicationContext;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

public class BaseVerticle extends AbstractVerticle {

	protected ApplicationContext context;
	protected EventBus eventBus;
	
	public BaseVerticle() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseVerticle(ApplicationContext context) {
		this.context = context;
	}
	
	@Override
	public void start() throws Exception {
		// TODO Auto-generated method stub
		super.start();
//		eventBus = 
	}
}
