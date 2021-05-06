package com.server.vieco.service;

import com.server.vieco.domain.CarInformation;
import com.server.vieco.domain.CarInformationRepository;
import com.server.vieco.web.dto.CarInformationRequestDto;
import com.server.vieco.web.dto.CarInformationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<CarInformationResponseDto> findAll() {
        List<CarInformation> all = carInformationRepository.findAll();
        List<CarInformationResponseDto> dtoEntities = new ArrayList<>();

        for (CarInformation entity : all) {
            CarInformationResponseDto result = new CarInformationResponseDto(entity);
            dtoEntities.add(result);
        }

        return dtoEntities;
    }

    public CarInformationResponseDto findById(Long id) {
        CarInformation entity = carInformationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 자동차 정보가 없습니다. id = " + id));
        return new CarInformationResponseDto(entity);
    }

    public List<CarInformationResponseDto> findByCarNameContainingAndCarTypeContaining(String carType, String carName) {
        List<CarInformation> entities = null;
        List<CarInformationResponseDto> dtoEntities = new ArrayList<>();
        try {
            entities = carInformationRepository.findByCarTypeContainingAndCarNameContaining(carType, carName);

            for (CarInformation entity : entities) {
                CarInformationResponseDto result = new CarInformationResponseDto(entity);
                dtoEntities.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dtoEntities;
    }
    /*
    public List<CarInformationResponseDto> findByCarNameContaining(String carName, String carType) {
        List<CarInformation> entities = null;
        List<CarInformationResponseDto> dtoEntities = new ArrayList<>();
        try {
            entities = carInformationRepository.findByCarNameContainingAndCarType(carName, carType);

            for (CarInformation entity : entities) {
                CarInformationResponseDto result = new CarInformationResponseDto(entity);
                dtoEntities.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dtoEntities;
    }
     */
}
