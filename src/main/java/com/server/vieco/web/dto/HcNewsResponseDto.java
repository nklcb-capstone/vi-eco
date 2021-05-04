package com.server.vieco.web.dto;

import com.server.vieco.domain.HcNews;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class HcNewsResponseDto {

    private Long id;
    private LocalDateTime date;
    private String category;
    private String section;
    private String publisher;
    private String author;
    private String title;
    private String url;
    private LocalDateTime savedDate;

    public HcNewsResponseDto(HcNews entity) {
        this.id = entity.getId();
        this.date = entity.getDate();
        this.category = entity.getCategory();
        this.section = entity.getSection();
        this.publisher = entity.getAuthor();
        this.author = entity.getAuthor();
        this.title = entity.getTitle();
        this.url = entity.getUrl();
        this.savedDate = getSavedDate();
    }
}
