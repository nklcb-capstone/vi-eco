package com.server.vieco.domain;


import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class CarInformation {

    @Id @GeneratedValue
    @Column(name = "information_id")
    private Long id;

    @Column(nullable = false)
    private String carName;

    @Column(nullable = false)
    private String carType;

    @Column(nullable = false)
    private String fuelEfficiency;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String pictureName;

    @Builder
    public CarInformation(String carName, String carType, String fuelEfficiency, String link, String pictureName) {
        this.carName = carName;
        this.carType = carType;
        this.fuelEfficiency = fuelEfficiency;
        this.link = link;
        this.pictureName = pictureName;
    }
}
