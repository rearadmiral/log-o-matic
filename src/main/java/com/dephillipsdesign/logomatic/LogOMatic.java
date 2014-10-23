package com.dephillipsdesign.logomatic;

import java.lang.Class;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.TypeVariable;

public class LogOMatic {

    public static final LogLevel DEBUG = LogLevel.DEBUG;
    public static final LogLevel INFO = LogLevel.INFO;
    public static final LogLevel ERROR = LogLevel.ERROR;

    public static Logger getLogger(Class clazz) {

        Class loggingClass = null;
        try {
            loggingClass = Class.forName(Logger.class.getPackage().getName() + ".DefaultAndroidLogger");

            Constructor constructor = loggingClass.getDeclaredConstructors()[0];
            return (Logger) constructor.newInstance(clazz);

        } catch (ClassNotFoundException e) {
            return new DefaultLogger(clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
