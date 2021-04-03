package com.server.vieco.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class news {

    @Id @GeneratedValue
    private String title;

    private String content;

    private LocalDateTime newsDateTime;

    private String companyName;

    private String category;

    private LocalDateTime savedDateTime;
}
