package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "mvc/api/student")
public class StudentAPI {
    @Autowired
    StudentService studentService;
    List<Student> list;


    //get all student
    @GetMapping
    public List<Student> getAll() {
        list = studentService.getAll();
        return list;
    }


    //get student by id
    @GetMapping(path = "{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }


    //add student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        list.add(student);
        studentService.add(student);
        return student;
    }

    //upsert a student
    @PutMapping(path = "{id}")
    public Student update(@RequestBody Student student, @PathVariable Long id) {
        studentService.update(student, id);
        return student;
    }

    //delete student
    @DeleteMapping(path = {"{id}"})
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
