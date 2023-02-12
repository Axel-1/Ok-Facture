package io.axel1.okfacture.dto;

import io.axel1.okfacture.entity.Client;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * A DTO for the {@link io.axel1.okfacture.entity.Facture} entity
 */
public record FactureDto(Integer id, LocalDate dateFacturation, LocalDate dateEcheance, String conditionsReg,
                         Client client, List<LigneFactureDto> lignesFacture, Double totalHt,
                         Double totalTtc) implements Serializable {
}