package org.example.skillboxstudents.service;

import org.example.skillboxstudents.dto.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentStoreService {
    private final Map<Long, Student> students = new HashMap<>();
    private final AtomicLong atomicLong = new AtomicLong();

    public Student save(String firstName, String lastName, Integer age) {
        long id = atomicLong.incrementAndGet();
        Student student = new Student(id, firstName, lastName, age);
        students.put(id, student);
        return students.get(id);
    }

    public Student delete(Long id) {
        return students.remove(id);
    }

    public void deleteAll() {
        students.clear();
    }

    public Collection<Student> getAll() {
        return students.values();
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }
}
