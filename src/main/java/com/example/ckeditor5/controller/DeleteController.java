package com.example.ckeditor5.controller;

import com.example.ckeditor5.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class DeleteController {

    private final ArticleService articleService;

    @GetMapping("/delete/{id}")
    public String deleteLogic(@PathVariable Long id) {

        articleService.deleteArticle(id);

        return "redirect:/list";
    }
}
