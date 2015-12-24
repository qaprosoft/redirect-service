package com.mlb.webservice.utils;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;

import java.io.StringWriter;
import java.io.Writer;

public class VelocityUtils {

	private static final String UTF8 = "utf-8";

	static {
		Velocity.setProperty("resource.loader", "classpath");
		Velocity.setProperty("classpath.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
	}

	public static String mergeTemplate(String contextKey, String contextValue, String template) {

		Velocity.init();

		Context context = new VelocityContext();
		context.put(contextKey, contextValue);
		Writer writer = new StringWriter();
		Velocity.mergeTemplate(template, UTF8, context, writer);
		return writer.toString();
	}
}
