package com.example.demo.service;

import com.example.demo.dto.TeaDto;
import com.example.demo.mapper.TeaMapper;
import com.example.demo.model.Tea;
import com.example.demo.model.Category;
import com.example.demo.repository.TeaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeaServiceImpl implements TeaService{
    private final TeaRepository teaRepository;
    private final TeaMapper teaMapper;

    @Override
    public TeaDto save(Tea tea) {
        return teaMapper.teaEntityToDto(teaRepository.save(tea));
    }

    @Override
    public TeaDto findByName(String name) {
        return teaMapper.teaEntityToDto(teaRepository.findByName(name));
    }

    @Override
    public List<TeaDto> findAll() {
        return teaMapper.teaListEntityToDto(teaRepository.findAll());
    }

    @Override
    public List<TeaDto> findByCategory(Category category) {
        return teaMapper.teaListEntityToDto(teaRepository.findByCategory(category));
    }

    @Override
    @Transactional
    public void update(Tea tea) {
        teaRepository.updateTea(tea.getName(),tea.getQuantity(),tea.getPrice(),
                tea.getDescription(),tea.getImage(),tea.getCategory());
    }

    @Override
    public void delete(Tea tea) {
        teaRepository.delete(tea);
    }

    @Override
    public void deleteTeaById(Integer id) {
        teaRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteTeaByName(String name)
    {
        teaRepository.deleteByName(name);
    }
    @Override
    public TeaDto findById(Integer id) {
        return teaMapper.teaEntityToDto(teaRepository.findById(id).orElse(null));
    }
}
