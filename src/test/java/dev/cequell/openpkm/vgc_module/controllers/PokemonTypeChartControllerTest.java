package dev.cequell.openpkm.vgc_module.controllers;

import dev.cequell.openpkm.vgc_module.configs.DatabaseTestConfig;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonProtoDto;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonProtoService;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonRequestProtoDto;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonResponseProtoDto;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.smallrye.mutiny.Uni;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
@QuarkusTestResource(
        value = DatabaseTestConfig.class,
        restrictToAnnotatedClass = true
)
class PokemonTypeChartControllerTest {
    @BeforeAll
    static void beforeAll() {
        final var pokemonUuid = "c648da05-dda4-41d3-b5fd-a286f44d06e5";
        final var mockPokemonProtoService = Mockito.mock(PokemonProtoService.class);
        Mockito.doAnswer(invocationOnMock -> {
            final var pokemon = PokemonProtoDto.newBuilder()
                    .setPokemonUuid(pokemonUuid)
                    .setName("Dummymon")
                    .build();
            final var response = PokemonResponseProtoDto.newBuilder()
                    .addPokemon(pokemon)
                    .build();
            return Uni.createFrom().item(response);
        }).when(mockPokemonProtoService).byId(Mockito.any(PokemonRequestProtoDto.class));
//        QuarkusMock.installMockForType(mockPokemonProtoService, PokemonProtoService.class);
    }

    @Test
    void fromPokemonUuid() {
        // Given
        final var pokemonUuid = "c648da05-dda4-41d3-b5fd-a286f44d06e5";
//        final var query = """
//            getPokemonDetail(
//                id:"%s")
//            }{
//                id,
//                name
//            }
//        """.formatted(pokemonUuid);

        // When / Then
        RestAssured.given()
                .when().contentType(ContentType.JSON)
                .body("{\"query\":\"{getPokemonDetail(id:'c648da05-dda4-41d3-b5fd-a286f44d06e5')}{id,name}}\"}")
                .post("/ql")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "errors", Matchers.nullValue(),
                        "data.getPokemonDetails.id", Matchers.is(pokemonUuid)
                );
    }
}