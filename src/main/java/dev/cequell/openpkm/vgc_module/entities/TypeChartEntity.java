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
@Table(name = "type_chart")
@Entity
public class TypeChartEntity extends PanacheEntityBase {
    @Id
    public UUID id;

    @Column(name = "gen_id")
    public UUID genId;

    @Column(name = "attacking")
    public UUID attackingTypeId;

    @Column(name = "defending")
    public UUID defendingTypeId;

    @Column(name = "multiplier")
    public double multiplier;
}
