package com.server.vieco.service;

import com.server.vieco.domain.CarInformation;
import com.server.vieco.domain.CarInformationRepository;
import com.server.vieco.web.dto.CarInformationRequestDto;
import com.server.vieco.web.dto.CarInformationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarInformationService {

    private final CarInformationRepository carInformationRepository;

    @Transactional
    public Long save(CarInformationRequestDto carInformationRequestDto) {
        return carInformationRepository.save(carInformationRequestDto.toEntity())
                .getId();
    }


    public CarInformationResponseDto findById(Long id) {
        CarInformation entity = carInformationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 자동차 정보가 없습니다. id = " + id));
        return new CarInformationResponseDto(entity);
    }
}
