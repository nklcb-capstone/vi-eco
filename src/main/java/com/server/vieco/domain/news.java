package com.server.vieco.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class news {

    @Id @GeneratedValue
    private String id;

    private String title;

    private String content;

    private LocalDateTime newsDateTime;

    private String companyName;

    private String category;

    private LocalDateTime savedDateTime;
}
