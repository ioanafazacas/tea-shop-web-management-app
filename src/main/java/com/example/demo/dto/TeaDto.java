package com.example.demo.dto;

import com.example.demo.model.Type;
import lombok.Builder;

@Builder
public record TeaDto(
        String name,
        int quantity,
        float price,
        String description,
        Type tip
) {
}
