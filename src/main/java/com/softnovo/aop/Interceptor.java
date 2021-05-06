package com.softnovo.aop;

import java.lang.reflect.InvocationTargetException;

/**
 * @author cgm
 */
public interface Interceptor {
    boolean before();

    void after();

    Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    void afterReturning();

    void afterThrowing();

    boolean useAround();
}
