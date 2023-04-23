package com.example.numbers.controller;

import com.example.numbers.domain.NumberDto;
import com.example.numbers.domain.RandomStringGenerator;
import com.example.numbers.domain.Student;
import com.example.numbers.domain.StudentsNumber;
import com.example.numbers.event.NumberRegisteredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

@RestController
@RequestMapping("/v1/students")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private ApplicationEventPublisher publisher;

    @PostMapping("/createStudent")
    public void createStudent(@RequestBody Student student) {
        int n = 20;
        int z = 10;

        logger.info(student.getFirstName() + " " + student.getLastName());
    }
    @PostMapping("/createNStudents")
    public void createNStudents(@RequestBody StudentsNumber studentsNumber) throws NoSuchFieldException, NoSuchMethodException {
        int n = 20;
        int z = 10;
        RandomStringGenerator generator = new RandomStringGenerator(10);
        List<Student> students = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Student student = new Student(generator.generateString(), generator.generateString(), z);
            students.add(student);
        }

        Map<Object, String> indexNumberMap = new HashMap();

        students.forEach(student -> {
            Field indexNumberField = null;
            try {
                indexNumberField = Student.class.getDeclaredField("indexNumber");
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
            indexNumberField.setAccessible(true);
            try {
                String value = (String)indexNumberField.get(student);
                indexNumberMap.put(student, value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        });
        logger.info("--------student : indexNumber:-------------");
        for(Object key : indexNumberMap.keySet()) {
            logger.info(key + ": " + indexNumberMap.get(key));
        }
    }

}
