package com.example.ckeditor5.controller;

import com.example.ckeditor5.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class EditorController {

    private final ArticleService articleService;

    @GetMapping("/editor")
    public String editorPage() {

        return "editor";
    }

    @GetMapping("/editor/{id}")
    public String updatePage(@PathVariable Long id, Model model) {

        model.addAttribute("Article", articleService.getArticle(id));

        return "editor";
    }
}
