package org.example.skillboxstudents.event;

import lombok.Getter;
import org.example.skillboxstudents.dto.Student;
import org.springframework.context.ApplicationEvent;

@Getter
public class AddStudentEvent extends ApplicationEvent {
    private final Student student;

    public AddStudentEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
