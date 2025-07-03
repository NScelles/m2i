package org.example.order.exeptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Not found");
    }
}
