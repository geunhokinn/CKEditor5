package com.example.ckeditor5.controller;

import com.example.ckeditor5.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/article/{id}")
    public String articlePage(@PathVariable Long id, Model model) {

        model.addAttribute("Article", articleService.getArticle(id));

        return "article";
    }
}
