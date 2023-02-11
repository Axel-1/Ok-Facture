package io.axel1.okfacture.service;

import io.axel1.okfacture.repository.TvaRepository;
import org.springframework.stereotype.Service;

@Service
public class TvaService {
    private final TvaRepository tvaRepository;

    public TvaService(TvaRepository tvaRepository) {
        this.tvaRepository = tvaRepository;
    }
}
