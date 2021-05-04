package com.server.vieco.web.dto;

import com.server.vieco.domain.EcNews;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class EcNewsResponseDto {

    private Long id;
    private LocalDateTime date;
    private String category;
    private String section;
    private String publisher;
    private String author;
    private String title;
    private String url;
    private LocalDateTime savedDate;

    public EcNewsResponseDto(EcNews entity) {
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
