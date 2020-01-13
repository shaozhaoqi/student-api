package com.fh.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.StudentBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface StudentDao extends BaseMapper<StudentBean> {
}
