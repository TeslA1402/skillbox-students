package org.example.skillboxstudents.service;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@ConditionalOnProperty("app.student.init")
@Service
@RequiredArgsConstructor
public class StudentInitService {
    private final StudentStoreService studentStoreService;
    private final Faker faker;
    @Value("${app.student.count}")
    private Integer count;

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        for (int i = 0; i < count; i++) {
            studentStoreService.save(faker.name().firstName(), faker.name().lastName(), faker.random().nextInt(18, 50));
        }
    }
}
