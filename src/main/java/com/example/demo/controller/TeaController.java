package com.example.demo.controller;

import com.example.demo.service.TeaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TeaController {
    private final TeaService teaService;
}
