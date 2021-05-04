package com.server.vieco.controller;

import com.server.vieco.service.EcNewsService;
import com.server.vieco.web.dto.CarInformationRequestDto;
import com.server.vieco.web.dto.CarInformationResponseDto;
import com.server.vieco.web.dto.EcNewsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NewsApiController {

    private final EcNewsService ecNewsService;
    /*
    @PostMapping("/api/car/information")
    public Long save(@RequestBody CarInformationRequestDto carInformationRequestDto) {
        return carInformationService.save(carInformationRequestDto);
    }

    @GetMapping("/api/car/information/search")
    public List<CarInformationResponseDto> findAll() {
        return carInformationService.findAll();
    }

    @GetMapping("/api/car/information/search/{id}")
    public CarInformationResponseDto findById(@PathVariable Long id) {
        return carInformationService.findById(id);
    }


    @GetMapping("/api/car/information/search")
    public List<CarInformationResponseDto> findByCarNameContaining(@RequestParam(required = false) String carName) {
        if (carName == null) {
            return carInformationService.findAll();
        }
        return carInformationService.findByCarNameContaining(carName);
    }

     */

    @GetMapping("/api/news/search")
    public List<EcNewsResponseDto> findAll() {
        return ecNewsService.findAll();
    }
}
