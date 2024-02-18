package dev.cequell.openpkm.vgc_module.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "type_chart_generation")
@Entity
public class TypeChartGenerationEntity extends PanacheEntityBase {
    @Id
    public UUID id;

    @Column(name = "generation")
    public String generation;
}
