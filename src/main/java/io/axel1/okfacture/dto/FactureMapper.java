package io.axel1.okfacture.dto;

import io.axel1.okfacture.entity.Facture;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {LigneFactureMapper.class})
public interface FactureMapper {
    Facture toEntity(PostFactureDto postFactureDto);

    PostFactureDto toPostDto(Facture facture);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Facture partialUpdate(PostFactureDto postFactureDto, @MappingTarget Facture facture);

    Facture toEntity(FactureDto factureDto);

    FactureDto toDto(Facture facture);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Facture partialUpdate(FactureDto factureDto, @MappingTarget Facture facture);

    @AfterMapping
    default void linkLignesFacture(@MappingTarget Facture facture) {
        facture.getLignesFacture().forEach(lignesFacture -> lignesFacture.setFacture(facture));
    }
}