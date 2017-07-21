package com.example.studentdemo.mapper;

import com.example.studentdemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentMapper {
    public Integer isExist(Integer id);
    public Map<String,Object> getStudentById(Integer id );
    public List<Map<String,Object>> getAllStudents();
    public Integer updateStudent(Student stu);
    public Integer insertStudent(Student stu);
    public Integer deleteStudent(Integer id);

}
