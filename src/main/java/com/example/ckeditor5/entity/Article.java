package com.example.ckeditor5.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Builder
    private Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Article buildArticle(String title, String content) {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
