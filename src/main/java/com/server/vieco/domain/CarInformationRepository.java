package com.server.vieco.domain;

import com.server.vieco.web.dto.CarInformationResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarInformationRepository extends JpaRepository<CarInformation, Long> {

    public List<CarInformation> findByCarNameContaining(String carName);
}
