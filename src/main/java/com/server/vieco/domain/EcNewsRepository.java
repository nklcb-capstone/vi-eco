package com.server.vieco.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EcNewsRepository extends JpaRepository<EcNews, Long> {

    public List<EcNews> findByTitleContaining(String title);
}
