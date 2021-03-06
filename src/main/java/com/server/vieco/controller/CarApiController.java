package com.server.vieco.controller;

import com.server.vieco.domain.CarInformation;
import com.server.vieco.service.CarInformationService;
import com.server.vieco.service.EcNewsService;
import com.server.vieco.web.dto.CarInformationRequestDto;
import com.server.vieco.web.dto.CarInformationResponseDto;
import com.server.vieco.web.dto.EcNewsResponseDto;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class CarApiController {

    private final CarInformationService carInformationService;
    private final EcNewsService ecNewsService;

    @GetMapping("/api/car/electric/station")
    public String callElectricCarApiWithJson(@RequestParam Long numOfRows, @RequestParam Long pageNo, @RequestParam(required = false) Long zcode) {
        StringBuffer result = new StringBuffer();
        String jsonPrintString = null;
        try {
            String apiUrl = "http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?" +
                    "serviceKey=BHsquG%2FvorGlzWqsqkFMoOYe5hAUjnunPhlWdwb3CILZ2xuTDoNGD2R1E81gl7Lzmtq3n2cCYW11YUqQGVlUWA%3D%3D" +
                    "&numOfRows=" + numOfRows +
                    "&pageNo=" + pageNo;
            if (zcode != null) {
                apiUrl += "&zcode=" + zcode;
            }
            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
            String returnLine;
            while ((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);
            }

            JSONObject jsonObject = XML.toJSONObject(result.toString());
            jsonPrintString = jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonPrintString;
    }

    @PostMapping("/api/car/information")
    public Long save(@RequestBody CarInformationRequestDto carInformationRequestDto) {
        return carInformationService.save(carInformationRequestDto);
    }

//    @GetMapping("/api/car/information/search")
//    public List<CarInformationResponseDto> findAll() {
//        return carInformationService.findAll();
//    }

    @GetMapping("/api/car/information/search/{id}")
    public CarInformationResponseDto findById(@PathVariable Long id) {
        return carInformationService.findById(id);
    }


    @GetMapping("/api/car/information/search")
    public List<CarInformationResponseDto> findByCarTypeContainingAndCarNameContaining(@RequestParam String carType, @RequestParam(required = false) String carName) {
        if (carName == null) {
            return carInformationService.findByCarType(carType);
        }
        return carInformationService.findByCarNameContainingAndCarTypeContaining(carType, carName);
    }

    @GetMapping("/api/news/search")
    public List<EcNewsResponseDto> findAll() {
        return ecNewsService.findAll();
    }
}

/**
 * ?????? ????????? ?????? ?????? api
 * [url]/api/car/information?carName={???????????????}
 */

/**
 * ????????? ????????? ?????? ?????? api
 * [url]/api/car/information?carName={???????????????}&type={??????????????? ex)?????????, ??????}
 */

/**
 * ?????? api
 * [url]/api/car/news?type={???????????????}
 */

/**
 * ?????? api
 * [url]/api/car/news?type={???????????????}&search={????????????}
 */
