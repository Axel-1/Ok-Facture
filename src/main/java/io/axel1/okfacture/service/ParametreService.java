package io.axel1.okfacture.service;

import io.axel1.okfacture.repository.ParametreRepository;
import org.springframework.stereotype.Service;

@Service
public class ParametreService {
    private final ParametreRepository parametreRepository;

    public ParametreService(ParametreRepository parametreRepository) {
        this.parametreRepository = parametreRepository;
    }
}
