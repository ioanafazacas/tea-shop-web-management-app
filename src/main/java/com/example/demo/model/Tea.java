package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TEA")
public class Tea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column(unique = true)
    @Size(min = 2, max = 50)
    private String name;
    @Builder.Default
    private int quantity = 0;
    @Builder.Default
    @Min(1)
    private float price = 0.0f;
    private String description;
    private String image;
    @Enumerated(EnumType.STRING)
    private Category category;
}
