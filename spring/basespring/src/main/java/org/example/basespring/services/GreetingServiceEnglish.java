package org.example.basespring.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Qualifier("greeting")
@Profile("EN")
public class GreetingServiceEnglish implements GreetingService {
    @Override
    public String greet() {
        return "Hello World from Greeting Service English";
    }
}
