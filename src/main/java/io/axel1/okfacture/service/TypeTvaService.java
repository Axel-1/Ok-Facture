package io.axel1.okfacture.service;

import io.axel1.okfacture.repository.TypeTvaRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeTvaService {
    private final TypeTvaRepository typeTvaRepository;

    public TypeTvaService(TypeTvaRepository typeTvaRepository) {
        this.typeTvaRepository = typeTvaRepository;
    }
}
