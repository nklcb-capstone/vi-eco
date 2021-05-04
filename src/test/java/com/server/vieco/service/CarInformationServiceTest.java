package com.server.vieco.service;

import com.server.vieco.domain.CarInformation;
import com.server.vieco.domain.CarInformationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CarInformationServiceTest {

    @Autowired
    CarInformationRepository carInformationRepository;

    /*
    @Test
    public void 자동차정보저장_불러오기() throws Exception {
        //given
        String carName = "testCar";
        String carType = "testType";
        String fuelEfficiency = "testEff";
        String link = "www.nnn.com";
        String pictureName = "nnn.png";

        carInformationRepository.save(CarInformation.builder()
                .carName(carName)
                .carType(carType)
                .fuelEfficiency(fuelEfficiency)
                .link(link)
                .pictureName(pictureName)
                .build()
        );
        //when
        List<CarInformation> informationList = carInformationRepository.findAll();

        //then
        CarInformation carInformation = informationList.get(0);
        assertThat(carInformation.getCarName()).isEqualTo(carName);
        assertThat(carInformation.getCarType()).isEqualTo(carType);
        assertThat(carInformation.getFuelEfficiency()).isEqualTo(fuelEfficiency);
        assertThat(carInformation.getLink()).isEqualTo(link);
        assertThat(carInformation.getPictureName()).isEqualTo(pictureName);
    }
*/
}