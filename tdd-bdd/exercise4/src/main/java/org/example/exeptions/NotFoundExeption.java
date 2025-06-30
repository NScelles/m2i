package org.example.exeptions;

public class NotFoundExeption extends RuntimeException {
    public NotFoundExeption(String message) {
        super(message);
    }
}
