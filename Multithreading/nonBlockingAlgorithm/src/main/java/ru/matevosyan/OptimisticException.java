package ru.matevosyan;

/**
 * Created by Admin on 02.11.2017.
 */
public class OptimisticException extends RuntimeException {
    public OptimisticException(String msg) {
        super(msg);
    }
}
