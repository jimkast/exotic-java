package org.jimkast.ooj.error;

public final class OojException extends Exception {

    public OojException(String message) {
        super(message);
    }

    public OojException(String message, Throwable cause) {
        super(message, cause);
    }
}
