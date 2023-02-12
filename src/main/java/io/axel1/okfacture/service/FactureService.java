package io.axel1.okfacture.service;

import io.axel1.okfacture.entity.Client;
import io.axel1.okfacture.entity.Facture;
import io.axel1.okfacture.entity.LigneFacture;
import io.axel1.okfacture.entity.Produit;
import io.axel1.okfacture.repository.FactureRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public Facture save(Facture facture, Client client) {
        facture.setClient(client);
        facture.setDateFacturation(LocalDate.now());

        return factureRepository.save(facture);
    }

    public Facture save(Facture facture) {
        return factureRepository.save(facture);
    }

    public Facture addLigneFacture(Facture facture, Produit produit, LigneFacture ligneFacture) {
        //TODO Vérifier que le produit n'est pas déjà dans la facture, si oui, ajouter la quantité
        ligneFacture.setProduit(produit);
        ligneFacture.setFacture(facture);
        ligneFacture.setPrixFactureHt(ligneFacture.getProduit().getTarifHt());

        facture.addLigneFacture(ligneFacture);

        return save(facture);
    }
}
