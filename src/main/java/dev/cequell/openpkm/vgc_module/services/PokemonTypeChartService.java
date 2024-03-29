package dev.cequell.openpkm.vgc_module.services;

import dev.cequell.openpkm.vgc_module.enums.MutiplierModeEnum;
import dev.cequell.openpkm.vgc_module.enums.TypeChartGenerationEnum;
import dev.cequell.openpkm.vgc_module.enums.TypeSlugEnum;
import dev.cequell.openpkm.vgc_module.maps.PokemonDetailMapper;
import dev.cequell.openpkm.vgc_module.models.PokemonDetail;
import dev.cequell.openpkm.vgc_module.models.TypeMultiplier;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonProtoDto;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonProtoService;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonRequestProtoDto;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonResponseProtoDto;
import dev.cequell.openpkm.vgc_module.repositories.TypeChartRepository;
import io.quarkus.grpc.GrpcClient;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.util.*;

@RequiredArgsConstructor
@ApplicationScoped
public class PokemonTypeChartService {
    private final TypeChartRepository typeChartRepository;
    private final PokemonDetailMapper pokemonDetailMapper;

    @GrpcClient("pokemon")
    PokemonProtoService pokemonProtoService;

    public PokemonDetail execute(
            final UUID pokemonUuid,
            final TypeChartGenerationEnum generationEnum,
            final MutiplierModeEnum multiplierMode
    ) {
        final var pokemon = getPokemon(pokemonUuid).getPokemon(0);
        final var typeList = genTypeList(pokemon);

        final var attackingMap = genMapType();
        final var defendingMap = genMapType();

        typeChartRepository.streamAll()
                .filter(el -> el.typeChartGeneration.id.equals(generationEnum.getValue()))
                .toList()
                .forEach(el -> {
                    if(typeList.contains(el.attackingTypeId)) {
                        var currentValue = attackingMap.get(el.defendingTypeId);
                        attackingMap.replace(el.defendingTypeId, currentValue*el.multiplier);
                    }
                    if(typeList.contains(el.defendingTypeId)) {
                        var currentValue = defendingMap.get(el.attackingTypeId);
                        defendingMap.replace(el.attackingTypeId, currentValue*el.multiplier);
                    }
                });

        var attackingList = mapWeaknessList(attackingMap);
        var defendingList = mapWeaknessList(defendingMap);

        if(multiplierMode == MutiplierModeEnum.SIMPLIFIED) {
            attackingList = attackingList.stream().filter(el -> el.getMultiplier() != 1.0).toList();
            defendingList = defendingList.stream().filter(el -> el.getMultiplier() != 1.0).toList();
        }

        return pokemonDetailMapper.mapDetails(pokemon, attackingList, defendingList);
    }

    private PokemonResponseProtoDto getPokemon(final UUID pokemonUuid) {
        return pokemonProtoService.byId(
                PokemonRequestProtoDto.newBuilder()
                        .addPokemonUuid(pokemonUuid.toString())
                        .build()
        ).await().atMost(Duration.ofSeconds(3));
    }

    private ArrayList<UUID> genTypeList(final PokemonProtoDto pokemon) {
        final var typeList = new ArrayList<UUID>();

        final var primaryType = UUID.fromString(pokemon.getPrimaryType().getTypeUuid());
        typeList.add(primaryType);

        if(pokemon.hasSecondaryType()) {
            final var secondaryType = UUID.fromString(pokemon.getSecondaryType().getTypeUuid());
            typeList.add(secondaryType);
        }

        return typeList;
    }

    private Map<UUID, Double> genMapType() {
        final var mapType = new HashMap<UUID, Double>();
        for(var type : TypeSlugEnum.values()) {
            mapType.put(type.getValue(), 1.0);
        }
        return mapType;
    }

    private List<TypeMultiplier> mapWeaknessList(final Map<UUID, Double> typeChart) {
        var result = new ArrayList<TypeMultiplier>();

        var builder = TypeMultiplier.builder();
        for(var type : typeChart.keySet()) {
            var typeEnum = TypeSlugEnum.from(type);
            result.add(
                    builder
                            .typeId(type)
                            .multiplier(typeChart.get(type))
                            .typeName(typeEnum.getLabel())
                            .typeSlug(typeEnum.name())
                            .build()
            );
        }

        return result;
    }
}
