package dev.cequell.openpkm.vgc_module.controllers;

import dev.cequell.openpkm.vgc_module.configs.VGCDatabaseTestConfig;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@QuarkusTest
@QuarkusTestResource(value = VGCDatabaseTestConfig.class, restrictToAnnotatedClass = true)
class PokemonTypeChartControllerTest {
    @Test
    void fromPokemonUuid() {
        // Given
        final var pokemonUuid = "5b04a3c4-7b3e-4bbb-9877-f9de33f45eb9";
        final var query = """
            getPokemonDetail(
                id:"%s")
            }{
                id,
                name
            }
        """.formatted(pokemonUuid);

        // When / Then
        RestAssured.given().log().all()
                .when().contentType(ContentType.JSON)
                .body("{\"query\":\"%s\"}".formatted(query))
                .post("/ql")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "errors", Matchers.nullValue()
//                        "data.getPokemonDetails.id", Matchers.is(pokemonUuid)
                );
    }
}