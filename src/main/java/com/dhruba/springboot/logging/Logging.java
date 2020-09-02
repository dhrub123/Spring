package com.dhruba.springboot.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {
	private static final Logger logger = LoggerFactory.getLogger(Logging.class);

	public void log() {
		logger.info("This is info");
		logger.warn("This is a warning");
		logger.error("This is an error");
	}

}
