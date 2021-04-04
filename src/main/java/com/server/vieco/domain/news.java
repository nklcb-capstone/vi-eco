package com.server.vieco.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class news {

    @Id @GeneratedValue
    @Column(name = "news_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime newsDateTime;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private LocalDateTime savedDateTime;

    @Builder
    public news(String title, String content, LocalDateTime newsDateTime, String companyName, String category, LocalDateTime savedDateTime) {
        this.title = title;
        this.content = content;
        this.newsDateTime = newsDateTime;
        this.companyName = companyName;
        this.category = category;
        this.savedDateTime = savedDateTime;
    }
}
