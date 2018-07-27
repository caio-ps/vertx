package io.vertx.sample;

import io.vertx.rxjava.core.AbstractVerticle;

public class MyFirstRXVerticle extends AbstractVerticle {

	@Override
	public void start() {
		
		var server = vertx.createHttpServer();
		
		server.requestStream().toObservable()
			.subscribe(req ->
				req.response().end("Hello from ".concat(Thread.currentThread().getName())));
		
		server.rxListen(8080).subscribe();
		
	}
	
}
