package com.example.demo.service;

import com.example.demo.dto.TeaDto;
import com.example.demo.mapper.TeaMapper;
import com.example.demo.model.Tea;
import com.example.demo.model.Type;
import com.example.demo.repository.TeaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeaServiceImpl implements TeaService{
    private TeaRepository teaRepository;
    private TeaMapper teaMapper;

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
    public List<TeaDto> findByTip(Type tip) {
        return teaMapper.teaListEntityToDto(teaRepository.findByTip(tip));
    }

    @Override
    public TeaDto update(Tea tea) {
        return null;//mai trebuie regandit findByName+save
    }

    @Override
    public void delete(Tea tea) {
        teaRepository.delete(tea);
    }
}
