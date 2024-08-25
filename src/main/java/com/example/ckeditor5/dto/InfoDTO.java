package com.example.ckeditor5.dto;


import com.example.ckeditor5.entity.Article;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InfoDTO {

    private Long id;
    private String title;
    private String content;

    @Builder
    public InfoDTO(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static InfoDTO fromEntity(Article article) {
        return InfoDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .build();
    }
}
