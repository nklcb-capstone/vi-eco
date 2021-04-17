package com.server.vieco.service;

import com.server.vieco.domain.CarInformation;
import com.server.vieco.domain.CarInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarInformationService {

    private final CarInformationRepository carInformationRepository;

    public CarInformation findByName(String carName) {
        return carInformationRepository.findByName(carName);
    }
}
