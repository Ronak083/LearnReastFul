package com.example.task1learn.Student;

import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping(path = "/getstudent")
    public Student getStudent(){
        return new Student("RK", "GUP");
    }

    @GetMapping(path = "/getstudents")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("abs", "qwe"));
        students.add(new Student("abe", "qwt"));
        students.add(new Student("abr", "qwy"));
        students.add(new Student("abt", "qwu"));
        return students;
    }

    //Path Variable
    @GetMapping(path = "/student/{first}/{last}")
    public Student studentPathVariable(@PathVariable("first") String firstname,
                                       @PathVariable("last") String lastname){
        return new Student(firstname, lastname);
    }

    //query Parameters
    //https://localhost:8080/student?st=Ronak&nd=Gupta
@GetMapping(path = "/student/query")
    public Student studentQueryParameter(@RequestParam(name = "st") String firstname,
                                         @RequestParam(name = "nd") String lastname){
        return new Student(firstname, lastname);
    }
}
