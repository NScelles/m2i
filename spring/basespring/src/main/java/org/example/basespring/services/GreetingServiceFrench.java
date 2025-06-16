package org.example.basespring.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Qualifier("salutation")
@Profile("FR")
public class GreetingServiceFrench implements GreetingService {
    @Override
    public String greet() {
        return "Bonjour Monde depuis salutation service français";
    }
}
