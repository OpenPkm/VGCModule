package dev.cequell.openpkm.vgc_module.controllers;

import dev.cequell.openpkm.vgc_module.enums.GenerationEnum;
import dev.cequell.openpkm.vgc_module.services.PokemonTypeChartService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Produces(MediaType.APPLICATION_JSON)
@Path("/TypeChart")
public class PokemonTypeChartController {
    private final PokemonTypeChartService pokemonTypeChartService;

    public PokemonTypeChartController(
            final PokemonTypeChartService pokemonTypeChartService
    ) {
        this.pokemonTypeChartService = pokemonTypeChartService;
    }

    @GET
    @Path("/fromPokemonUuid/{pokemonUuid}")
    @Blocking
    public Uni<Response> fromPokemonUuid(final UUID pokemonUuid) {
        final var result = pokemonTypeChartService.execute(pokemonUuid, GenerationEnum.Gen_IX.getValue());

        return Uni.createFrom().item(
                Response.ok()
                        .entity(result)
                        .build()
        );
    }
}
