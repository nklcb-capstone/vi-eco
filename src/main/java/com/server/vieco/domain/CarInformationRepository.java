package com.server.vieco.domain;

import com.server.vieco.web.dto.CarInformationResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarInformationRepository extends JpaRepository<CarInformation, Long> {

    public List<CarInformation> findByCarType(String carType);
    public List<CarInformation> findByCarTypeContainingAndCarNameContaining(String carType, String carName);
}
