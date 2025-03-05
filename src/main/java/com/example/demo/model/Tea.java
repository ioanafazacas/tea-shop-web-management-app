package com.example.demo.model;

import jakarta.persistence.*;
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
    private String name;
    @Builder.Default
    private int quantity = 0;
    @Builder.Default
    private float price = 0.0f;
    private String description; //grupate mai restrands???
    //private static Image image; //mai e de lucru

    private Category category;//negru , verde, fructat , medicinal

}
