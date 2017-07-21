package com.example.studentdemo.controller;

import com.example.studentdemo.entity.Banji;
import com.example.studentdemo.mapper.BanjiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BanjiController {

    @Autowired
    private BanjiMapper classMap;

    @RequestMapping("/getAllClasses")
    @ResponseBody
    public List<Banji> getAllClass(){
        return classMap.getAllClasses();
    }
}
