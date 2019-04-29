package com.kyle.firstspringbootproject.mapper;

import com.kyle.firstspringbootproject.pojo.StudentBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    StudentBean getStudentById(int id);
}
