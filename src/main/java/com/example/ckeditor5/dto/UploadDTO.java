package com.example.ckeditor5.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UploadDTO {

    private Boolean uploaded;
    private String url;

    @Builder
    public UploadDTO(Boolean uploaded, String url) {
        this.uploaded = uploaded;
        this.url = url;
    }
}
