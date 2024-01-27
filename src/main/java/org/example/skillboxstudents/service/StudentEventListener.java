package org.example.skillboxstudents.service;

import org.example.skillboxstudents.event.AddStudentEvent;
import org.example.skillboxstudents.event.RemoveStudentEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class StudentEventListener {
    @EventListener(AddStudentEvent.class)
    public void onEvent(AddStudentEvent event) {
        System.out.println(MessageFormat.format("Event: add student {0}", event.getStudent()));
    }

    @EventListener(RemoveStudentEvent.class)
    public void onEvent(RemoveStudentEvent event) {
        System.out.println(MessageFormat.format("Event: remove student with id {0}", event.getStudentId()));
    }
}
