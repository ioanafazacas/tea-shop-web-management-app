package com.example.demo.dto;

import com.example.demo.model.Category;
import lombok.Builder;

@Builder
public record TeaDto(
        String name,
        int quantity,
        float price,
        String description,
        Category category,
        String image
) {
}
