package com.example.demo.controller;

import com.example.demo.dto.TeaDto;
import com.example.demo.mapper.TeaMapper;
import com.example.demo.model.Category;
import com.example.demo.model.Tea;
import com.example.demo.service.TeaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("teas")
public class TeaController {
    private final TeaService teaService;
    private final TeaMapper teaMapper;
    private static String IMAGE_UPLOAD_DIR = "src/main/resources/static/images/";

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

    @GetMapping("create")
    public String displayCreateForm(Model model){
        model.addAttribute("title","Add Tea");
        model.addAttribute(new Tea());
        model.addAttribute("categories",Category.values());
        return "teas/create";
    }

/*    @PostMapping("create")
    public String processCreateTeaForm(@ModelAttribute @Valid Tea tea, Model model, Errors errors, @RequestParam("image") MultipartFile file)throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + fileNames.toString());
        System.out.println("path"+ fileNameAndPath);
        System.out.println("path"+ fileNames);
        if(errors.hasErrors()){
            System.out.println("se blocheaza aici " +errors.getAllErrors() );
            model.addAttribute("title", "Add Tea");
            return "teas/create";
        }
        System.out.println(Category.valueOf(tea.getCategory().name()));
        tea.setImage(fileNames.toString());
        tea.setCategory(Category.valueOf(tea.getCategory().name()));
        teaService.save(tea);
        return "redirect:/teas";
    }*/

    @PostMapping("create")
    public String processCreateTeaForm(@Valid @ModelAttribute("tea") TeaDto teaDto,
                                       BindingResult result,
                                       @RequestParam("imageFile") MultipartFile imageFile) {
        if (result.hasErrors()) {
            return "create-tea";
        }
        System.out.println(teaDto.name());

        String imageName = "";
        if (!imageFile.isEmpty()) {
            try {
                imageName = imageFile.getOriginalFilename();
                Path imagePath = Path.of(IMAGE_UPLOAD_DIR + imageName);
                Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Tea tea = teaMapper.teaDtoToEntity(teaDto);
        tea.setImage(imageName);
        tea.setCategory(Category.valueOf(tea.getCategory().name()));

        teaService.save(tea);

        return "redirect:/teas";
    }

    @GetMapping("delete")
    public String displayDeleteTeaForm(Model model){
        model.addAttribute("title", "Delete Tea");
        model.addAttribute("teas",teaService.findAll());
        return "teas/delete";
    }

    @PostMapping("delete")
    public String processDeleteTeaForm(@RequestParam(required = false) String[] teaNames){
        if(teaNames != null){
            for(String name : teaNames){
                teaService.deleteTeaByName(name);
                System.out.println("da");
            }
        }
        System.out.println("nu");
        return "redirect:/teas";
    }

    @GetMapping("update")
    public String displayUpdateTeaForm(@RequestParam String teaName, Model model){
        TeaDto tea= teaService.findByName(teaName);
        if(tea==null){
            model.addAttribute("title","Invalid tea NAME: "+teaName);
        }else{
            model.addAttribute("title", "Edit Tea Information:" + tea.name());
            model.addAttribute("tea",tea);
            model.addAttribute("categories",Category.values());

        }
        return "teas/update";
    }

    @PostMapping("update")
    public String processUpdateTeaForm(@Valid @ModelAttribute("tea") TeaDto teaDto, Model model,@RequestParam("imageFile") MultipartFile imageFile, @RequestParam("oldImage") String oldImage){
        String imageName = "";
        if (!imageFile.isEmpty()) {
            try {
                imageName = imageFile.getOriginalFilename();
                Path imagePath = Path.of(IMAGE_UPLOAD_DIR + imageName);
                Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            imageName=oldImage;
        }
        Tea tea= teaMapper.teaDtoToEntity(teaDto);
        tea.setImage(imageName);
        teaService.update(tea);
        return "redirect:/teas";
    }


}
