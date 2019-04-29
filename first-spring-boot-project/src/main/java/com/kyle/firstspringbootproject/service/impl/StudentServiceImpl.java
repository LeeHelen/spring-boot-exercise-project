package com.kyle.firstspringbootproject.service.impl;

import com.kyle.firstspringbootproject.mapper.StudentMapper;
import com.kyle.firstspringbootproject.pojo.StudentBean;
import com.kyle.firstspringbootproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentBean findStudentById(int id) {
        return studentMapper.getStudentById(id);
    }
}
