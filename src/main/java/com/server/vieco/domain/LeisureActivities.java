package com.server.vieco.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class LeisureActivities {

    @Id @GeneratedValue
    @Column(name = "activites_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String urlLink;

    @Builder
    public LeisureActivities(String title, String category, String urlLink) {
        this.title = title;
        this.category = category;
        this.urlLink = urlLink;
    }
}
