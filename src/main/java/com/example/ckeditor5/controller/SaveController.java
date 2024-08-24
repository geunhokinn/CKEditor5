package com.example.ckeditor5.controller;

import com.example.ckeditor5.dto.SaveDTO;
import com.example.ckeditor5.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SaveController {

    private final ArticleService articleService;

    @PostMapping("/save")
    public String saveLogic(SaveDTO saveDTO) {

        articleService.saveArticle(saveDTO);

        return "redirect:/";
    }
}
