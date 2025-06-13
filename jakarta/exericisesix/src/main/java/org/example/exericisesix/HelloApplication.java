package org.example.exericisesix;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.example.exericisesix.utils.SessionFactorySingleton;
import org.hibernate.Session;

@ApplicationPath("/api")
public class HelloApplication extends Application {
    static {
        SessionFactorySingleton.initSessionFactory();
    }
}