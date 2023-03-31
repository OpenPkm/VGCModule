package dev.cequell.openpkm.vgc_module.controllers;

import dev.cequell.openpkm.vgc_module.enums.GenerationEnum;
import dev.cequell.openpkm.vgc_module.models.PokemonDetail;
import dev.cequell.openpkm.vgc_module.services.PokemonTypeChartService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.UUID;

@SuppressWarnings("unused")
@GraphQLApi
public class PokemonTypeChartController {
    private final PokemonTypeChartService pokemonTypeChartService;

    public PokemonTypeChartController(
            final PokemonTypeChartService pokemonTypeChartService
    ) {
        this.pokemonTypeChartService = pokemonTypeChartService;
    }

    @Query("getPokemonDetails")
    @Description("Get a pokemon with weakness and resistance details")
    @Blocking
    public Uni<PokemonDetail> getPokemonDetail(
            @Name("id") final UUID pokemonUuid
    ) {
        final var result = pokemonTypeChartService.execute(pokemonUuid, GenerationEnum.Gen_IX.getValue());
        return Uni.createFrom().item(result);
    }
}
