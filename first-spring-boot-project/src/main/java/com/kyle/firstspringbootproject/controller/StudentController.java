package com.kyle.firstspringbootproject.controller;

import com.kyle.firstspringbootproject.pojo.StudentBean;
import com.kyle.firstspringbootproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping
    public StudentBean getStudent(@RequestParam int id){
        StudentBean xxx = studentService.findStudentById(id);
        System.out.println(xxx.getSex());
        return studentService.findStudentById(id);
    }
}
