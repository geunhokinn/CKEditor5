package com.example.ckeditor5.service;

import com.example.ckeditor5.dto.InfoDTO;
import com.example.ckeditor5.dto.SaveDTO;
import com.example.ckeditor5.entity.Article;
import com.example.ckeditor5.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<InfoDTO> getArticles() {

        List<Article> articles = articleRepository.findAll();

        return articles.stream()
                .map(InfoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public InfoDTO getArticle(Long id) {

        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 조회할 수 없습니다."));

        return InfoDTO.fromEntity(article);
    }
}
