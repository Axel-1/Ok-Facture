package io.axel1.okfacture.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link io.axel1.okfacture.entity.Facture} entity
 */
public record PostFactureDto(LocalDate dateEcheance, String conditionsReg) implements Serializable {
}