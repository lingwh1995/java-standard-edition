package org.bluebridge.beginner;

import java.util.logging.Logger;

public class LoggingTest {

    private static Logger logger = Logger.getGlobal();
    public static void main(String[] args) {
        logger.info("info......");
        logger.warning("warning......");
        logger.fine("fine......");
        logger.severe("severe......");
    }
}
