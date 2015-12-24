package com.mlb.webservice;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class Starter extends SpringBootServletInitializer {

	private static final int DEFAULT_JETTY_PORT = 7000;

	private static final String TIME_ZONE = "Europe/Kiev";

	public static void main(String[] args) throws Exception {
		System.setProperty("user.timezone", TIME_ZONE);
		System.setProperty("org.eclipse.jetty.server.Request.maxFormContentSize", "10000000");

		Server server = new Server(DEFAULT_JETTY_PORT);

		WebAppContext context = new WebAppContext();

		context.setResourceBase("./src/main/webapp");

		context.setParentLoaderPriority(true);

		server.setHandler(context);

		server.start();
		server.join();

	}

}
