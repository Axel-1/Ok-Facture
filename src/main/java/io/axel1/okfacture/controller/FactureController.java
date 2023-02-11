package io.axel1.okfacture.controller;

import io.axel1.okfacture.entity.Facture;
import io.axel1.okfacture.service.FactureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
public class FactureController {
    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @GetMapping
    public List<Facture> findAll() {
        return factureService.findAll();
    }

    @GetMapping("/{id}")
    public Facture findById(@PathVariable Integer id) {
        return factureService.findById(id).orElse(null);
    }
}
