package com.server.vieco.service;

import com.server.vieco.domain.EcNewsRepository;
import com.server.vieco.domain.HcNews;
import com.server.vieco.domain.HcNewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EcNewsService {

    private final EcNewsRepository ecNewsRepository;



}
