package com.dephillipsdesign.logomatic;

public interface Logger {
    void log(LogLevel level, String msg);
    void logf(LogLevel level, String msg, Object... args);
    void debugf(String msg, Object... args);
    void infof(String msg, Object... args);
    void errorf(String msg, Object... args);
    void debug(String msg);
    void info(String msg);
    void error(String msg);
    void error(String msg, Throwable t);

}
