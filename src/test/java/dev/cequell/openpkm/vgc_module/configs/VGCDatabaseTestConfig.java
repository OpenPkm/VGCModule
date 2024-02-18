package dev.cequell.openpkm.vgc_module.configs;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Hashtable;
import java.util.Map;

public class VGCDatabaseTestConfig implements QuarkusTestResourceLifecycleManager {
    private PostgreSQLContainer postgreSQLContainer;

    @Override
    public Map<String, String> start() {
        postgreSQLContainer = new PostgreSQLContainer(DockerImageName.parse("postgres:15-alpine"))
                .withDatabaseName("openpokemon_vgc_db")
                .withUsername("PokeAdmin")
                .withPassword("toxtricity1996");
        postgreSQLContainer.start();

        var result = new Hashtable<String, String>();
        result.put("DATABASE_PORT", String.valueOf(postgreSQLContainer.getMappedPort(5432)));
        return result;
    }

    @Override
    public void stop() {
        postgreSQLContainer.stop();
    }
}
