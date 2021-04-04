package com.server.vieco.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NewsRepositoryTest {

    @Autowired
    NewsRepository newsRepository;

    @AfterEach
    public void cleanup() {
        newsRepository.deleteAll();
    }

    @Test
    public void 뉴스_저장하기() throws Exception {
        //given
        String title = "테스트 뉴스";
        String content = "테스트입니다.";
        LocalDateTime newsDateTime = LocalDateTime.of(2021, 3, 5, 0, 0, 0);
        String companyName = "test";
        String category = "sports";
        LocalDateTime saveDateTime = LocalDateTime.of(2021, 4, 5, 0, 0, 0);

        newsRepository.save(News.builder()
                .title(title)
                .content(content)
                .newsDateTime(newsDateTime)
                .companyName(companyName)
                .category(category)
                .savedDateTime(saveDateTime)
                .build());

        //when
        List<News> newsList = newsRepository.findAll();

        //then
        News news = newsList.get(0);
        assertThat(news.getTitle()).isEqualTo(title);
        assertThat(news.getContent()).isEqualTo(content);
        assertThat(news.getNewsDateTime()).isEqualTo(newsDateTime);
        assertThat(news.getCompanyName()).isEqualTo(companyName);
        assertThat(news.getCategory()).isEqualTo(category);
        assertThat(news.getSavedDateTime()).isEqualTo(saveDateTime);

    }
}