package com.server.vieco.web.dto;

import com.server.vieco.domain.CarInformation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
public class CarInformationRequestDto {

    private String carName;
    private String carType;
    private String fuelEfficiency;
    private String link;
    private String pictureName;

    @Builder
    public CarInformationRequestDto(String carName, String carType, String fuelEfficiency, String link, String pictureName) {
        this.carName = carName;
        this.carType = carType;
        this.fuelEfficiency = fuelEfficiency;
        this.link = link;
        this.pictureName = pictureName;
    }

    public CarInformation toEntity() {
        return CarInformation.builder()
                .carName(carName)
                .carType(carType)
                .fuelEfficiency(fuelEfficiency)
                .link(link)
                .pictureName(pictureName)
                .build();
    }
}
