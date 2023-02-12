package io.axel1.okfacture.controller;

import io.axel1.okfacture.dto.FactureDto;
import io.axel1.okfacture.dto.FactureMapper;
import io.axel1.okfacture.dto.LigneFactureMapper;
import io.axel1.okfacture.dto.PostLigneFactureDto;
import io.axel1.okfacture.entity.Facture;
import io.axel1.okfacture.entity.LigneFacture;
import io.axel1.okfacture.entity.Produit;
import io.axel1.okfacture.service.FactureService;
import io.axel1.okfacture.service.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/factures")
public class FactureController {
    private final FactureService factureService;
    private final FactureMapper factureMapper;
    private final ProduitService produitService;
    private final LigneFactureMapper ligneFactureMapper;

    public FactureController(FactureService factureService,
                             FactureMapper factureMapper, ProduitService produitService,
                             LigneFactureMapper ligneFactureMapper) {
        this.factureService = factureService;
        this.factureMapper = factureMapper;
        this.produitService = produitService;
        this.ligneFactureMapper = ligneFactureMapper;
    }

    @GetMapping
    public List<FactureDto> findAll() {
        return factureService.findAll().stream().map(factureMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FactureDto findById(@PathVariable Integer id) {
        return factureMapper.toDto(
                factureService.findById(id).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                )
        );
    }

    @PostMapping("/{id}/produits/{idProduit}")
    public Facture addProduit(@PathVariable("id") Integer idFacture, @PathVariable("idProduit") Integer idProduit, @RequestBody PostLigneFactureDto postLigneFactureDto) {
        Facture facture = factureService.findById(idFacture).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Produit produit = produitService.findById(idProduit).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        LigneFacture ligneFacture = ligneFactureMapper.toEntity(postLigneFactureDto);


        return factureService.addLigneFacture(facture, produit, ligneFacture);
    }
}
