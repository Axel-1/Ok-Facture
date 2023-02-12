package io.axel1.okfacture.dto;

import io.axel1.okfacture.entity.Produit;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProduitMapper {
    Produit toEntity(FactureProduitDto factureProduitDto);

    FactureProduitDto toDto(Produit produit);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Produit partialUpdate(FactureProduitDto factureProduitDto, @MappingTarget Produit produit);
}