package com.baeldung.rest;

import com.baeldung.model.Article;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class RestServiceVerticle extends AbstractVerticle {
	
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new RestServiceVerticle());
    }
    
    @Override
    public void start(Promise<Void> promise) {

        Router router = Router.router(vertx);
        router.get("/api/baeldung/articles/article/:id")
                .handler(this::getArticles);

        vertx.createHttpServer()
                .requestHandler(router)
                .listen(config().getInteger("http.port", 8081), result -> {
                    if (result.succeeded()) {
                    	promise.complete();
                    } else {
                    	promise.fail(result.cause());
                    }
                });
    }

    private void getArticles(RoutingContext routingContext) {
        String articleId = routingContext.request().getParam("id");
        Article article = new Article(articleId, "This is an intro to vertx", "baeldung", "01-02-2017", 1578);

        routingContext.response()
                .putHeader("content-type", "application/json")
                .setStatusCode(200)
                .end(article.toString());
    }

}
