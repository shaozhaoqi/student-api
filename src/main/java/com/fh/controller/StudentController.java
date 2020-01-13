package com.fh.controller;

import com.fh.bean.StudentBean;
import com.fh.service.StudentService;
import com.fh.util.AliyunOssUtils;
import com.fh.util.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("queryStudent")
    public Map queryStudent(){
        Map map = new HashMap();
        try {
            List list = studentService.queryStudent();
            map.put("code","200");
            map.put("message","success");
            map.put("data",list);
        }catch (Exception e){
            map.put("code","500");
            map.put("message","错误的学生信息为"+e.getMessage());
        }
        return map;
    }


    @RequestMapping("addstudent")
    public StudentBean addstudent(StudentBean studentBean){
        studentService.addstudent(studentBean);
        return studentBean;
    }

    /*
   initFileInput图片上传
    */
    //图片上传
    @RequestMapping("uploadFile")
    public Map<String,Object> uploadFile(@RequestParam("imgUrl") MultipartFile imgUrl){
        Map<String,Object> map = new HashMap<String,Object>();
        AliyunOssUtils aliyunOssUtils=new AliyunOssUtils();
        String url = "";
        try {
            /*获取上传的图片名称*/
            url = aliyunOssUtils.uploadImg2Oss(imgUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*拼接图片路径 并返回到前台*/
        String imageUrl = aliyunOssUtils.getImageUrl(url);
        map.put("data",imageUrl);
        return map;

    }


    @RequestMapping("delstudentid")
    public void delstudentid (int id){
        studentService.delstudentid(id);
    }

    @RequestMapping("getStudentByid")
    public ResponseServer getStudentByid(Integer id){
        StudentBean studentBean = studentService.getStudentByid(id);
        return ResponseServer.success(studentBean);
    }



}
