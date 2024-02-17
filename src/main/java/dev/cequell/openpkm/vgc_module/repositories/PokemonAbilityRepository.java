package dev.cequell.openpkm.vgc_module.repositories;

import dev.cequell.openpkm.vgc_module.entities.PokemonAbilityEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class PokemonAbilityRepository implements PanacheRepositoryBase<PokemonAbilityEntity, UUID> {
}
