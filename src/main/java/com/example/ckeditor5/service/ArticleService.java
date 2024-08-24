package com.example.ckeditor5.service;

import com.example.ckeditor5.dto.SaveDTO;
import com.example.ckeditor5.entity.Article;
import com.example.ckeditor5.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public void saveArticle(SaveDTO saveDTO) {

        Article article = Article.buildArticle(saveDTO.getTitle(), saveDTO.getContent());

        articleRepository.save(article);
    }
}
