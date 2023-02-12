package io.axel1.okfacture.dto;

import io.axel1.okfacture.entity.LigneFacture;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {ProduitMapper.class})
public interface LigneFactureMapper {
    LigneFacture toEntity(PostLigneFactureDto postLigneFactureDto);

    PostLigneFactureDto toPostDto(LigneFacture ligneFacture);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LigneFacture partialUpdate(PostLigneFactureDto postLigneFactureDto, @MappingTarget LigneFacture ligneFacture);

    LigneFacture toEntity(LigneFactureDto ligneFactureDto);

    LigneFactureDto toDto(LigneFacture ligneFacture);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LigneFacture partialUpdate(LigneFactureDto ligneFactureDto, @MappingTarget LigneFacture ligneFacture);
}