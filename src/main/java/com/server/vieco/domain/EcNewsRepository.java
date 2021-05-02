package com.server.vieco.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EcNewsRepository extends JpaRepository {

    public List<CarInformation> findByTitleContaining(String title);
}
