package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("t_student")
public class StudentBean {

    @TableId(value = "id", type = IdType.AUTO )
    private  Integer id;

    @TableField("name")
    private String name;

    @TableField("age")
    private int age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("birthday")
    private Date birthday;

    @TableField("address")
    private String address;

    @TableField("img")
    private String img;

    @TableField("isdel")
    private int isdel;

}
