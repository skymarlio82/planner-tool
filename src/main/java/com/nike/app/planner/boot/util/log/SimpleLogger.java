
package com.nike.app.planner.boot.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLogger {

	private static final Logger logger = LoggerFactory.getLogger(SimpleLogger.class);

	public final static String INFO  = "INFO ";
	public final static String DEBUG = "DEBUG";
	public final static String WARN  = "WARN ";
	public final static String ERROR = "ERROR";

	@SuppressWarnings("rawtypes")
	public final synchronized static void log(String logType, Class clazz,  String message) {
		logger.info(logType + "    CLASS - " + clazz + " : " + message);
	}
}