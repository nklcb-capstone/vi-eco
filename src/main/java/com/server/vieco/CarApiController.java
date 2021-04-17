package com.server.vieco;

import com.server.vieco.domain.CarInformation;
import com.server.vieco.service.CarInformationService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
@RequiredArgsConstructor
public class CarApiController {

    private final CarInformationService carInformationService;

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

    @GetMapping("/api/car/information")
    public CarInformation callCarInformation() {
//        CarInformation carInformation = carInformationService.findByName(carName);
        CarInformation carInformation = new CarInformation("test", "test", "test", "test", "test");
        return carInformation;
    }

}
