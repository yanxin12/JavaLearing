// -*- coding: utf-8 -*- 
/**
 * Project: Chapter_13
 * Creator: yanking
 * Create time: 2021-08-12 10:27
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.Exception;

public class CustomException extends RuntimeException{
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }
}
