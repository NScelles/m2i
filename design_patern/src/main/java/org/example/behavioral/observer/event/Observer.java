package org.example.behavioral.observer.event;

public interface Observer {
    void sendMessage(String message);
    void react();
}
