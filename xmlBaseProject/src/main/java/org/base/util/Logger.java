package org.base.util;

/**************************************************************
 * Filename : Logger.java Function : Comment : History :
 *
 * @version 1.0
 * @author du
 **************************************************************/

public class Logger {

	public final static String DEBUG_LOG = "debug_log";
	private static org.apache.logging.log4j.Logger debugLogger;
	private static org.apache.logging.log4j.Logger getLogger(String loggerName) {
		org.apache.logging.log4j.Logger logger = null;
		logger = debugLogger = debugLogger == null ? org.apache.logging.log4j.LogManager.getLogger(loggerName) : debugLogger;
		return logger;
	}

	/**
	 * DEBUG Log : 운영 & 개발 사용할 로그, debug_log로 동작
	 *
	 * @param obj
	 * @param msg
	 */
	public static String debug(Object obj, String msg) {
		return log(obj, org.apache.logging.log4j.Level.DEBUG, msg);
	}

	/**
	 * TRACE Log : 운영 & 개발 사용할 로그, debug_log로 동작
	 * @param obj
	 * @param msg
	 */

	public static String trace(Object obj,String msg) {
		return log(obj, org.apache.logging.log4j.Level.TRACE, msg);
	}


	/**
	 * INFO Log : 운영 & 개발 사용할 로그, debug_log로 동작
	 * @param obj
	 * @param msg
	 */
	public static String info(Object obj, String msg) {
		return log(obj, org.apache.logging.log4j.Level.INFO, msg);
	}

	/**
	 * WARN Log : 운영 & 개발 사용할 로그, debug_log로 동작
	 * @param obj
	 * @param msg
	 */
	public static String warn(Object obj, String msg) {
		return log(obj, org.apache.logging.log4j.Level.WARN, msg);
	}

	/**
	 * ERROR Log : 운영 & 개발 사용할 로그, debug_log로 동작
	 * @param obj
	 * @param msg
	 */
	public static String error(Object obj,String msg) {
		return log(obj, org.apache.logging.log4j.Level.ERROR, msg);
	}

	/**
	 * FATAL Log :  운영 & 개발 사용할 로그, debug_log로 동작
	 * @param obj
	 * @param msg
	 */
	public static String fatal(Object obj, String msg) {
		return log(obj, org.apache.logging.log4j.Level.FATAL, msg);
	}

	/**
	 * Log4j Logger
	 *
	 * @param obj 로그분류
	 * @param priority 로그 레벨
	 * @param msg 로그 내용
	 */
	private static String log(Object obj, org.apache.logging.log4j.Level level, String msg) {
		org.apache.logging.log4j.Logger logger = Logger.getLogger(obj == null ? null : obj
				.toString());
		if (logger == null) {
			return "logger is null";
		}

		StringBuilder sBuilder = new StringBuilder();

		StackTraceElement[] callerClass = Thread.currentThread().getStackTrace();
		String classInfo = (callerClass != null && callerClass.length >= 4) ? "["+ callerClass[3].getClassName() + "." + callerClass[3].getMethodName() + "]" : "[ . ]";
		sBuilder.append(classInfo);
		sBuilder.append(" : ");

		logger.log(level, sBuilder);
		sBuilder.append('\n');
		return sBuilder.toString();

	}
}
