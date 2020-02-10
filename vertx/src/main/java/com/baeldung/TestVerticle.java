package com.baeldung;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestVerticle extends AbstractVerticle {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestVerticle.class);

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		DeploymentOptions options = new DeploymentOptions();
		vertx.deployVerticle(new TestVerticle(), options);
	}

	@Override
	public void start() throws Exception {
		LOGGER.info("Starting up the application");
	}

	@Override
	public void stop() throws Exception {
		LOGGER.info("Shutting down the application");
	}

}
