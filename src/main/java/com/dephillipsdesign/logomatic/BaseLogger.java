package com.dephillipsdesign.logomatic;

public abstract class BaseLogger implements Logger {

    public abstract void log(LogLevel level, String msg);
    public abstract void error(String msg, Throwable t);

    @Override
    public void logf(LogLevel level, String msg, Object... args) {
       log(level, String.format(msg, args));
    }

    @Override
    public void debugf(String msg, Object... args) {
      debug(String.format(msg, args));
    }

    @Override
    public void infof(String msg, Object... args) {
       info(String.format(msg, args));
    }

    @Override
    public void errorf(String msg, Object... args) {
       error(String.format(msg, args));
    }

    @Override
    public void debug(String msg) {
        log(LogLevel.DEBUG, msg);
    }

    @Override
    public void info(String msg) {
        log(LogLevel.INFO, msg);
    }

    @Override
    public void error(String msg) {
        log(LogLevel.ERROR, msg);
    }
}
