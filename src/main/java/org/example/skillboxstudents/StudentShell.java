package org.example.skillboxstudents;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.example.skillboxstudents.dto.Student;
import org.example.skillboxstudents.event.AddStudentEvent;
import org.example.skillboxstudents.event.RemoveStudentEvent;
import org.example.skillboxstudents.service.StudentStoreService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import java.text.MessageFormat;
import java.util.stream.Collectors;

@ShellComponent
@RequiredArgsConstructor
public class StudentShell {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final StudentStoreService studentStoreService;

    @ShellMethod("Show all students")
    @ShellMethodAvailability("existsStudents")
    public String list() {
        return studentStoreService.getAll().stream().map(Student::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    @ShellMethod("Add student")
    public String add(@NotNull String firstName, @NotNull String lastName, @NotNull @PositiveOrZero Integer age) {
        Student student = studentStoreService.save(firstName, lastName, age);
        applicationEventPublisher.publishEvent(new AddStudentEvent(this, student));
        return MessageFormat.format("Added: {0}", student);
    }

    @ShellMethod("Remove student")
    public String remove(@NotNull Long id) {
        Student removed = studentStoreService.delete(id);
        if (removed != null) {
            applicationEventPublisher.publishEvent(new RemoveStudentEvent(this, id));
            return MessageFormat.format("Removed: {0}", removed);
        } else {
            return MessageFormat.format("Student with id {0} not found", id);
        }
    }

    @ShellMethod("Remove all students")
    public String removeAll() {
        studentStoreService.deleteAll();
        return "All students was removed";
    }

    private Availability existsStudents() {
        return studentStoreService.isEmpty() ? Availability.unavailable("No students") : Availability.available();
    }
}
