package io.axel1.okfacture.service;

import io.axel1.okfacture.entity.Facture;
import io.axel1.okfacture.repository.FactureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {
    private final FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    public List<Facture> findAll() {
        return factureRepository.findAll();
    }

    public Optional<Facture> findById(Integer id) {
        return factureRepository.findById(id);
    }
}
