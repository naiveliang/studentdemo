package com.example.studentdemo.controller;

import com.example.studentdemo.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class CourseController {

    @Autowired
    private CourseMapper courseMap;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String mainPage(){
//        return "course";
//    }

    @RequestMapping("/getAllCourses")
    @ResponseBody
    public List<Map<String,Object>> getAllCourses(){
        return courseMap.getAllCourses();
    }

    @RequestMapping("/getLikeSearchResults/{str}/{method}")
    @ResponseBody
    public List<Map<String,Object>> getLikeSearchResults(@PathVariable  String str, @PathVariable  String method){
        return courseMap.getLikeSearchResults(str,method);
    }
}
