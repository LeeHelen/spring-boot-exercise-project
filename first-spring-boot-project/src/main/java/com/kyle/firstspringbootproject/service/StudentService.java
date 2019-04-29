package com.kyle.firstspringbootproject.service;

import com.kyle.firstspringbootproject.pojo.StudentBean;

public interface StudentService {
    StudentBean findStudentById(int id);
}
