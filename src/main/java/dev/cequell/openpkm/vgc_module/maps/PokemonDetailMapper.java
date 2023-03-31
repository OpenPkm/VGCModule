package dev.cequell.openpkm.vgc_module.maps;

import dev.cequell.openpkm.vgc_module.models.PokemonDetail;
import dev.cequell.openpkm.vgc_module.models.TypeMultiplier;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonProtoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PokemonDetailMapper {
    @Mapping(target = "id", source = "dto.pokemonUuid")
    @Mapping(target = "primaryType.value", source = "dto.primaryType.typeUuid")
    @Mapping(target = "primaryType.label", source = "dto.primaryType.name")
    @Mapping(target = "secondaryType.value", source = "dto.secondaryType.typeUuid")
    @Mapping(target = "secondaryType.label", source = "dto.secondaryType.name")
    @Mapping(target = "attacking", source = "attackingMap")
    @Mapping(target = "defending", source = "defendingMap")
    PokemonDetail mapDetails(
            PokemonProtoDto dto,
            List<TypeMultiplier> attackingMap,
            List<TypeMultiplier> defendingMap);
}
