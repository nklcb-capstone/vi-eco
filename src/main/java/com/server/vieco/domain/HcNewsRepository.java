package com.server.vieco.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HcNewsRepository extends JpaRepository<HcNews, Long> {

    public List<CarInformation> findByTitleContaining(String title);
}
