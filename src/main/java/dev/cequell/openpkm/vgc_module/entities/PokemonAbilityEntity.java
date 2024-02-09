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
@Table(name = "pokemon_ability")
@Entity
public class PokemonAbilityEntity extends PanacheEntityBase {
    @Id
    public UUID id;

    @Column(name = "pokemon_id")
    public UUID pokemonId;

    @Column(name = "ability_id")
    public UUID abilityId;

    @Column(name = "hidden")
    public boolean hidden;

    @ManyToOne
    @JoinColumn(
            name = "ability_id",
            updatable = false,
            insertable = false
    )
    public AbilityEntity ability;
}
