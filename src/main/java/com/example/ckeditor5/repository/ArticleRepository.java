package com.example.ckeditor5.repository;

import com.example.ckeditor5.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
