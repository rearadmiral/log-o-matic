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

            for (Constructor cons : loggingClass.getDeclaredConstructors()) {
                for (TypeVariable tv : cons.getTypeParameters()) {
                     if (tv.getBounds().length == 1 && tv.getBounds()[0].equals(Class.class)){
                        return (Logger) cons.newInstance(clazz);
                    }
                }
            }


        } catch (ClassNotFoundException e) {
            return new DefaultLogger(clazz);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

}
