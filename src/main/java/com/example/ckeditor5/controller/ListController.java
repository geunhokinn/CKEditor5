package com.example.ckeditor5.controller;

import com.example.ckeditor5.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ListController {

    private final ArticleService articleService;

    @GetMapping("/list")
    public String listPage(Model model) {

        model.addAttribute("ArticleList", articleService.getArticles());

        return "list";
    }
}
