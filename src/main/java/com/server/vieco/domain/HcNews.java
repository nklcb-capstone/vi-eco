package com.server.vieco.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class HcNews extends News {

    @Builder
    public HcNews(LocalDateTime date, String category, String section, String publisher, String author, String title, String url, LocalDateTime savedDate) {
        super(date, category, section, publisher, author, title, url, savedDate);
    }
}
