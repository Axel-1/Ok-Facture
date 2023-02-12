package io.axel1.okfacture.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link io.axel1.okfacture.entity.LigneFacture} entity
 */
public record LigneFactureDto(FactureProduitDto produit, Integer qte, Double prixFactureHt, Double valeurTva,
                              Double totalPrixFactureHt) implements Serializable {
}