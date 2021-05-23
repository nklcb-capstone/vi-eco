package com.server.vieco.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class EcNews {

    @Id @GeneratedValue
    @Column(name = "news_id")
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String section;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime savedDate;

    @Builder
    public EcNews(Long id, LocalDateTime date, String category, String section, String publisher, String author, String title, String url, LocalDateTime savedDate) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.section = section;
        this.publisher = publisher;
        this.author = author;
        this.title = title;
        this.url = url;
        this.savedDate = savedDate;
    }
}
