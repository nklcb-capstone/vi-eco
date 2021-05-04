package com.server.vieco.service;

import com.server.vieco.domain.EcNews;
import com.server.vieco.domain.EcNewsRepository;
import com.server.vieco.domain.HcNews;
import com.server.vieco.domain.HcNewsRepository;
import com.server.vieco.web.dto.EcNewsResponseDto;
import com.server.vieco.web.dto.HcNewsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HcNewsService {

    private final HcNewsRepository hcNewsRepository;

    public List<HcNewsResponseDto> findAll() {
        List<HcNews> all = hcNewsRepository.findAll();
        List<HcNewsResponseDto> dtoEntities = new ArrayList<>();

        for (HcNews entity : all) {
            HcNewsResponseDto result = new HcNewsResponseDto(entity);
            dtoEntities.add(result);
        }

        return dtoEntities;
    }

    public HcNewsResponseDto findById(Long id) {
        HcNews entity = hcNewsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 뉴스 정보가 없습니다. id = " + id));
        return new HcNewsResponseDto(entity);
    }

    public List<HcNewsResponseDto> findByTitleContaining(String title) {
        List<HcNews> entities = null;
        List<HcNewsResponseDto> dtoEntities = new ArrayList<>();
        try {
            entities = hcNewsRepository.findByTitleContaining(title);

            for (HcNews entity : entities) {
                HcNewsResponseDto result = new HcNewsResponseDto(entity);
                dtoEntities.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dtoEntities;
    }
}
