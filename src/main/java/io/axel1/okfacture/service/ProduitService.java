package io.axel1.okfacture.service;

import io.axel1.okfacture.entity.Produit;
import io.axel1.okfacture.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Optional<Produit> findById(Integer id) {
        return produitRepository.findById(id);
    }
}
