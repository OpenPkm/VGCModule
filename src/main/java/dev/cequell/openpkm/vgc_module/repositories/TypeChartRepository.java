package dev.cequell.openpkm.vgc_module.repositories;

import dev.cequell.openpkm.vgc_module.entities.TypeChartEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class TypeChartRepository implements PanacheRepositoryBase<TypeChartEntity, UUID> {
}
