package org.example.skillboxstudents.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class RemoveStudentEvent extends ApplicationEvent {
    private final Long studentId;

    public RemoveStudentEvent(Object source, Long studentId) {
        super(source);
        this.studentId = studentId;
    }
}
