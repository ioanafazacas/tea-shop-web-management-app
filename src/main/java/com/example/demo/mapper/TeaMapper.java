package com.example.demo.mapper;

import com.example.demo.dto.TeaDto;
import com.example.demo.model.Tea;

import java.util.List;

public class TeaMapper {
    public TeaDto teaEntityToDto(Tea tea){
        return TeaDto.builder()
                .name(tea.getName())
                .quantity(tea.getQuantity())
                .price(tea.getPrice())
                .description(tea.getDescription())
                .tip(tea.getTip())
                .build();
    }
    public List<TeaDto> teaListEntityToDto(List<Tea> teas){
        return teas.stream()
                .map(tea -> teaEntityToDto(tea))
                .toList();
    }
    public Tea teaDtoToEntity(TeaDto teaDto){
        return Tea.builder()
                .name(teaDto.name())
                .quantity(teaDto.quantity())
                .price(teaDto.price())
                .description(teaDto.description())
                .tip(teaDto.tip())
                .build();
    }

}
