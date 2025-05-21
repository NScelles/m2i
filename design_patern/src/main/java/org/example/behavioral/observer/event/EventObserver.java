package org.example.behavioral.observer.event;

public interface EventObserver {
    void sendMessage(String message);
    void react();
}
