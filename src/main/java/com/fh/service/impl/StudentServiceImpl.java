package com.fh.service.impl;

import com.fh.bean.StudentBean;
import com.fh.dao.StudentDao;
import com.fh.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public List queryStudent() {
        return studentDao.selectList(null);
    }

    @Override
    public void addstudent(StudentBean studentBean) {
        studentDao.insert(studentBean);
    }

    @Override
    public void delstudentid(int id) {
        studentDao.deleteById(id);
    }

    @Override
    public StudentBean getStudentByid(Integer id) {
        return studentDao.selectById(id);
    }
}
