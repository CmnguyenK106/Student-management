package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.hcmut.cse.adsoftweng.lab.service.StudentService;
import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService Service;

    @GetMapping
    public List<Student> getAllStudents() {
        return Service.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return Service.getById(id);
    }
}
