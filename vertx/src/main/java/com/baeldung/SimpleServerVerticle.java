package com.baeldung;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class SimpleServerVerticle extends AbstractVerticle {

	public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new SimpleServerVerticle());
    }
	
    @Override
    public void start(Promise<Void> promise) {
        vertx.createHttpServer()
                .requestHandler(
                //  r -> r.response().end("Welcome to Vert.x Intro"))
                r -> r.response().end("Story Book"))
                .listen(config().getInteger("http.port", 8080), result -> {
                    if (result.succeeded()) {
                        promise.complete();
                    } else {
                    	promise.fail(result.cause());
                    }
                });
    }

}


