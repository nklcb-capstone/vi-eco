package com.server.vieco.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Repository
@RequiredArgsConstructor
public class CarInformationRepository {

    private final EntityManager em;

    public CarInformation findByName(String carName) {
        CarInformation carInformation = null;
        try {
            carInformation = em.createQuery("select ci from CarInformation ci where ci.carName = :carName", CarInformation.class)
                    .setParameter("carName", carName)
                    .getSingleResult();
        } catch (NoResultException e) {
        }
        return carInformation;
    }
}
