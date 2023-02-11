package io.axel1.okfacture.service;

import io.axel1.okfacture.repository.ProduitRepository;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
}
