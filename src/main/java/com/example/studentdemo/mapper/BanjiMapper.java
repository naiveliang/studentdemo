package com.example.studentdemo.mapper;

import com.example.studentdemo.entity.Banji;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BanjiMapper {
    public List<Banji> getAllClasses();
    public Integer getIdByName(String name);
}
