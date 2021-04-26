package com.server.vieco.controller;

import com.server.vieco.domain.CarInformation;
import com.server.vieco.domain.CarInformationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarInformationRepository carInformationRepository;

    @AfterEach
    public void tearDown() throws Exception {
        carInformationRepository.deleteAll();
    }

    @Test
    public void CarInformation_등록된다() throws Exception {
        //given
        String carName = "testCar";
        String carType = "testType";
        String fuelEfficiency = "testEff";
        String link = "www.nnn.com";
        String pictureName = "nnn.png";

        CarInformation requestDto = carInformationRepository.save(CarInformation.builder()
                .carName(carName)
                .carType(carType)
                .fuelEfficiency(fuelEfficiency)
                .link(link)
                .pictureName(pictureName)
                .build()
        );

        String url = "http://localhost:" + port + "/api/car/information";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<CarInformation> all = carInformationRepository.findAll();
        assertThat(all.get(0).getCarName()).isEqualTo(carName);
    }

}