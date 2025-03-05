package com.example.demo.mapper;

import com.example.demo.dto.TeaDto;
import com.example.demo.model.Tea;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TeaMapper {
    public TeaDto teaEntityToDto(Tea tea){
        return TeaDto.builder()
                .name(tea.getName())
                .quantity(tea.getQuantity())
                .price(tea.getPrice())
                .description(tea.getDescription())
                .category(tea.getCategory())
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
                .category(teaDto.category())
                .build();
    }

}
