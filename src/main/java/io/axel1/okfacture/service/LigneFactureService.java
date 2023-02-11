package io.axel1.okfacture.service;

import io.axel1.okfacture.repository.LigneFactureRepository;
import org.springframework.stereotype.Service;

@Service
public class LigneFactureService {
    private final LigneFactureRepository ligneFactureRepository;

    public LigneFactureService(LigneFactureRepository ligneFactureRepository) {
        this.ligneFactureRepository = ligneFactureRepository;
    }
}
