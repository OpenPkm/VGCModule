package dev.cequell.openpkm.vgc_module.repositories;

import dev.cequell.openpkm.vgc_module.entities.AbilityEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class AbilityRepository implements PanacheRepositoryBase<AbilityEntity, UUID> {
}
