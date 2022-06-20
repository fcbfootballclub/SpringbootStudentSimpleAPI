package com.example.demo.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //get all students
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    //get student by ID
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    //add a student
    public void add(Student student) {
        studentRepository.save(student);
    }

    //update a student
    public void update(Student student, Long id) {
        Optional<Student> foundStudent = studentRepository.findById(id);
        if(foundStudent.isPresent()) {
            foundStudent.get().setName(student.getName());
            foundStudent.get().setSalary_rate(student.getSalary_rate());
            foundStudent.get().setInsurance(student.getInsurance());
            System.out.println("Update thanh cong");
            studentRepository.save(foundStudent.get());
        }
        else {
            studentRepository.save(student);
            System.out.println("Tao moi thanh cong");
        }
    }

    //delete a student
    public void delete(Long id) {
        Optional<Student> foundStudent = studentRepository.findById(id);
        if(foundStudent.isPresent()){
            studentRepository.delete(foundStudent.get());
        }
        else {
            System.out.println("Delete khong thanh cong");
        }
    }

}
