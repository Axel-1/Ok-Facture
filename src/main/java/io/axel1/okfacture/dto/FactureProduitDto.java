package io.axel1.okfacture.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link io.axel1.okfacture.entity.Produit} entity
 */
public record FactureProduitDto(Integer id, String designation) implements Serializable {
}