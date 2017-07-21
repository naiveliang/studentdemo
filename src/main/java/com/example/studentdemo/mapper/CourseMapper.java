package com.example.studentdemo.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CourseMapper {
    public Integer deleteByUid(Integer id);
    public List<Map<String,Object>> getAllCourses();
    public List<Map<String,Object>> getLikeSearchResults(@Param("str") String str, @Param("method") String method);
}
