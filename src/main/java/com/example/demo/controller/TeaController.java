package com.example.demo.controller;

import com.example.demo.dto.TeaDto;
import com.example.demo.model.Category;
import com.example.demo.service.TeaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("teas")
public class TeaController {
    private final TeaService teaService;

    @GetMapping
    public String displayAllTeas(@RequestParam(required = false) Integer categoryId, Model model){
        if(categoryId == null){
            model.addAttribute("title", "All Teas");
            model.addAttribute("teas", teaService.findAll());
        }else{
             List<TeaDto> teas= teaService.findByCategory(Category.valueOf(categoryId));
             if(teas==null){
                 model.addAttribute("title", "Invalid Category ID: " + categoryId);
             }else{
                model.addAttribute("title","Teas in category: "+Category.valueOf(categoryId).name());
                model.addAttribute("teas", teas);
             }
        }
        return "teas/index";
    }
    @GetMapping("details")
    public String displayTeaDetails(@RequestParam String teaName, Model model){
        TeaDto tea= teaService.findByName(teaName);
        if(tea==null){
            model.addAttribute("title","Invalid tea NAME: "+teaName);
        }else{
            model.addAttribute("title", tea.name());
            model.addAttribute("tea",tea);
        }
        return "teas/details";
    }

}
