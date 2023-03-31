package dev.cequell.openpkm.vgc_module.controllers;

import dev.cequell.openpkm.vgc_module.configs.DatabaseTestConfig;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonProtoDto;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonProtoService;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonRequestProtoDto;
import dev.cequell.openpkm.vgc_module.proto.pokemon.PokemonResponseProtoDto;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.smallrye.mutiny.Uni;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.nullValue;

@QuarkusTest
@QuarkusTestResource(value = DatabaseTestConfig.class, restrictToAnnotatedClass = true)
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
        QuarkusMock.installMockForType(mockPokemonProtoService, PokemonProtoService.class);
    }

    @Test
    void fromPokemonUuid() {
        // Given
        final var pokemonUuid = "c648da05-dda4-41d3-b5fd-a286f44d06e5";
        final var query = """
                getPokemonDetail(
                    id:\\\"%s\\\")
                }{
                    id,
                    name
                }
                """.formatted(pokemonUuid);

        // When / Then
        given()
                .when().contentType(ContentType.JSON)
                .body("""
                        {
                            "query":"{%s}"
                        }
                        """.formatted(query))
                .post("/ql")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "errors", nullValue(),

                        "data.getPokemonDetails.id", is(pokemonUuid)
                );
    }
}