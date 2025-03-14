package com.example.demo.service;

import com.example.demo.dto.TeaDto;
import com.example.demo.model.Tea;
import com.example.demo.model.Category;

import java.util.List;

public interface TeaService {
    TeaDto save(Tea tea);
    TeaDto findByName(String name);
    List<TeaDto> findAll();
    List<TeaDto> findByCategory(Category category);
    void update(Tea tea);
    void delete(Tea tea);
    void deleteTeaById(Integer id);
    void deleteTeaByName(String name);
    TeaDto findById(Integer id);

}
