package logpack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingDemo {
	// pass your class name as a parameter in getLogger();
	private static final Logger logger = LogManager.getLogger(LoggingDemo.class);

	public static void main(String[] args) {
		System.out.println("\n");
		/*
		 * ------Configuration Files can be: A developer must created either of this
		 * configuration file below. log4j2.property , og4j2.xml file , or og4j2.yml
		*/
		// The different Logging methods (levels)
		logger.debug("This is a  --> debug msg ! ");
		logger.info("This is an  -->  Info  msg ! ");
		logger.error("This is a  --> Error msg ! ");
		logger.fatal("This is a  --> Fatal Error msg ! ");
		logger.warn("This is a  --> Warning  msg ! ");
		logger.trace("This is a  -->  trace msg ! ");
		//
		// --Using the error level in a your program -catch block in your code
		System.out.println("\n\n");
	}
}
