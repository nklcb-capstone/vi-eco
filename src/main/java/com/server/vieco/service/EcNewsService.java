package com.server.vieco.service;

import com.server.vieco.domain.EcNews;
import com.server.vieco.domain.EcNewsRepository;
import com.server.vieco.web.dto.EcNewsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EcNewsService {

    private final EcNewsRepository ecNewsRepository;

    public List<EcNewsResponseDto> findAll() {
        List<EcNews> all = ecNewsRepository.findAll();
        List<EcNewsResponseDto> dtoEntities = new ArrayList<>();

        for (EcNews entity : all) {
            EcNewsResponseDto result = new EcNewsResponseDto(entity);
            dtoEntities.add(result);
        }

        return dtoEntities;
    }

    public EcNewsResponseDto findById(Long id) {
        EcNews entity = ecNewsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 뉴스 정보가 없습니다. id = " + id));
        return new EcNewsResponseDto(entity);
    }
}
