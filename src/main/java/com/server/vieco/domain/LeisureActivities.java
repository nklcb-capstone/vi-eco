package com.server.vieco.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class LeisureActivities {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String category;

    private String urlLink;
}
