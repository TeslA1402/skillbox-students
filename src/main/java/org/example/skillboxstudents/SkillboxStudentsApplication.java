package org.example.skillboxstudents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SkillboxStudentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkillboxStudentsApplication.class, args);
    }

}
