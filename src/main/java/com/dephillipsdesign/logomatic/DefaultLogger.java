package com.dephillipsdesign.logomatic;

import java.util.logging.*;
import java.util.logging.Logger;

public class DefaultLogger extends BaseLogger {

    private final Logger logger;

    public DefaultLogger(Class clazz) {
        this.logger = java.util.logging.Logger.getLogger(clazz.getCanonicalName());
    }

    @Override
    public void log(LogLevel level, String msg) {
        Level javaLevel;
        switch(level) {
            case DEBUG:
                javaLevel = Level.FINER;
                break;
            case INFO:
                javaLevel = Level.INFO;
                break;
            case ERROR:
                 javaLevel = Level.SEVERE;
            default:
                throw new UnsupportedOperationException("Only DEBUG, INFO, ERROR supported");
        }
        logger.log(javaLevel, msg);
    }

    @Override
    public void error(String msg, Throwable t) {
        logger.log(Level.SEVERE, msg, t);
    }
}
