package dev.cequell.openpkm.vgc_module.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "type_chart")
@Entity
public class TypeChartEntity extends PanacheEntityBase {
    @Id
    public UUID id;

    @Column(name = "attacking")
    public UUID attackingTypeId;

    @Column(name = "defending")
    public UUID defendingTypeId;

    @Column(name = "multiplier")
    public double multiplier;

    @ManyToOne
    @JoinColumn(
            name = "type_chart_generation_id",
            insertable = false,
            updatable = false
    )
    public TypeChartGenerationEntity typeChartGeneration;
}
