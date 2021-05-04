package com.server.vieco.controller;

import com.server.vieco.domain.CarInformation;
import com.server.vieco.domain.CarInformationRepository;
import com.server.vieco.service.CarInformationService;
import com.server.vieco.web.dto.CarInformationResponseDto;
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

    @Autowired
    private CarInformationService carInformationService;

    @AfterEach
    public void tearDown() throws Exception {
        carInformationRepository.deleteAll();
    }

    /*
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
     */

/*
    @Test
    public void CarInformation_자동차이름으로_찾기() throws Exception {
        //given
        String carName = "testCar";
        String carType = "testType";
        String fuelEfficiency = "testEff";
        String link = "www.nnn.com";
        String pictureName = "nnn.png";

        String carName1 = "testCar1";
        String carType1 = "testType1";
        String fuelEfficiency1 = "testEff1";
        String link1 = "www.nnn.com1";
        String pictureName1 = "nnn.png1";

        CarInformation requestDto = carInformationRepository.save(CarInformation.builder()
                .carName(carName)
                .carType(carType)
                .fuelEfficiency(fuelEfficiency)
                .link(link)
                .pictureName(pictureName)
                .build()
        );

//        CarInformation requestDto1 = carInformationRepository.save(CarInformation.builder()
//                .carName(carName1)
//                .carType(carType1)
//                .fuelEfficiency(fuelEfficiency1)
//                .link(link1)
//                .pictureName(pictureName1)
//                .build()
//        );

        String searchKeyword = "test";
        String url = "http://localhost:" + port + "/api/car/information";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.getForEntity(url + "?carName={carName}", );

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<CarInformation> all = carInformationRepository.findAll();
//        List<CarInformation> all = carInformationRepository.findByCarNameLike(searchKeyword);
        assertThat(all.get(1).getCarName()).isEqualTo(carName);
    }
*/

}