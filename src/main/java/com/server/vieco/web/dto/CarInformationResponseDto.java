package com.server.vieco.web.dto;

import com.server.vieco.domain.CarInformation;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CarInformationResponseDto {

    private Long id;
    private String carName;
    private String carType;
    private String fuelEfficiency;
    private String link;
    private String pictureName;

    public CarInformationResponseDto(CarInformation entity) {
        this.id = entity.getId();
        this.carName = entity.getCarName();
        this.carType = entity.getCarType();
        this.fuelEfficiency = entity.getFuelEfficiency();
        this.link = entity.getLink();
        this.pictureName = entity.getPictureName();
    }
}
