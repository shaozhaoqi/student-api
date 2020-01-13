package com.fh.service;

import com.fh.bean.StudentBean;

import java.util.List;

public interface StudentService {
    List queryStudent();

    void addstudent(StudentBean studentBean);

    void delstudentid(int id);

    StudentBean getStudentByid(Integer id);
}
