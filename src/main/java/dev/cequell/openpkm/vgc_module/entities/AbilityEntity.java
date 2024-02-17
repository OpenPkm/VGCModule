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
@Table(name = "ability")
@Entity
public class AbilityEntity extends PanacheEntityBase {
    @Id
    public UUID id;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;
}
