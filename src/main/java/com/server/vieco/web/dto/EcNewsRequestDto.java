package com.server.vieco.web.dto;

import com.server.vieco.domain.EcNews;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class EcNewsRequestDto {

    private LocalDateTime date;
    private String category;
    private String section;
    private String publisher;
    private String author;
    private String title;
    private String url;
    private LocalDateTime savedDate;

    @Builder
    public EcNewsRequestDto(LocalDateTime date, String category, String section, String publisher, String author, String title, String url, LocalDateTime savedDate) {
        this.date = date;
        this.category = category;
        this.section = section;
        this.publisher = publisher;
        this.author = author;
        this.title = title;
        this.url = url;
        this.savedDate = savedDate;
    }

    public EcNews toEntity() {
        return EcNews.builder()
                .date(date)
                .category(category)
                .section(section)
                .publisher(publisher)
                .author(author)
                .title(title)
                .url(url)
                .savedDate(savedDate)
                .build();
    }
}
