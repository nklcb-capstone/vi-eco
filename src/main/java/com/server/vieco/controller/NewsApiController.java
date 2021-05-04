package com.server.vieco.controller;

import com.server.vieco.service.EcNewsService;
import com.server.vieco.web.dto.EcNewsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class NewsApiController {

    private final EcNewsService ecNewsService;

//    @GetMapping("/api/news/search")
//    public List<EcNewsResponseDto> findAll() {
//        return ecNewsService.findAll();
//    }

    @GetMapping("/api/news/electric/search/{id}")
    public EcNewsResponseDto findById(@PathVariable Long id) {
        return ecNewsService.findById(id);
    }
}
