package com.server.vieco.controller;

import com.server.vieco.service.EcNewsService;
import com.server.vieco.service.HcNewsService;
import com.server.vieco.web.dto.EcNewsResponseDto;
import com.server.vieco.web.dto.HcNewsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class HcNewsApiController {

    private final HcNewsService hcNewsService;

//    @GetMapping("/api/news/search")
//    public List<EcNewsResponseDto> findAll() {
//        return ecNewsService.findAll();
//    }

    @GetMapping("/api/news/hydrogen/search/{id}")
    public HcNewsResponseDto findById(@PathVariable Long id) {
        return hcNewsService.findById(id);
    }

    @GetMapping("/api/news/hydrogen/search")
    public List<HcNewsResponseDto> findByTitleContaining(@RequestParam(required = false) String title) {
        if (title == null) {
            return hcNewsService.findAll();
        }
        return hcNewsService.findByTitleContaining(title);
    }
}
