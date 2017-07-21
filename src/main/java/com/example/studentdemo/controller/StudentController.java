package com.example.studentdemo.controller;

import com.example.studentdemo.entity.Student;
import com.example.studentdemo.mapper.BanjiMapper;
import com.example.studentdemo.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.studentdemo.mapper.StudentMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentMapper stuMap;

    @Autowired
    private BanjiMapper classMap;

    @Autowired
    private CourseMapper courseMap;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(){
        return "student";
    }

    public Boolean isExist(Integer id){
        Integer inte = stuMap.isExist(id);
        if(inte==null) return false;
        else return true;
    }

    @RequestMapping("/getStudentById/{id}")
    @ResponseBody
    public Map<String,Object> getStudentById(@PathVariable Integer id ){
        return stuMap.getStudentById(id);
    }

    @RequestMapping("/getAllStudents")
    @ResponseBody
    public List<Map<String,Object>> getAllStudents(){
        return stuMap.getAllStudents();
    }

    @RequestMapping("/updateStudent")
    @ResponseBody
    public Integer updateStudent(@RequestBody Student stu){
        return stuMap.updateStudent(stu);
    }

    @RequestMapping("/insertStudent")
    @ResponseBody
    public Integer insertStudent(@RequestBody Student stu){
        return stuMap.insertStudent(stu);
    }

    @RequestMapping("/deleteStudent/{id}")
    @ResponseBody
    public Integer deleteStudent(@PathVariable Integer id){
        int deleteCourseRet = courseMap.deleteByUid(id);
        int deleteStudent = stuMap.deleteStudent(id) ;
        if(deleteCourseRet>0 || deleteStudent>0) return 1;
        else return 0;
    }

}
