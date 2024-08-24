package com.example.ckeditor5.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveDTO {

    private String title;
    private String content;

    @Builder
    public SaveDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
