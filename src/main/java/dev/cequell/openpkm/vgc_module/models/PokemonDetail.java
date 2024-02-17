package dev.cequell.openpkm.vgc_module.models;

import dev.cequell.openpkm.vgc_module.entities.PokemonAbilityEntity;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonDetail {
    private UUID                       id;
    private int                        nationalDexNo;
    private int                        regionalDexNo;
    private String                     name;
    private String                     classification;
    private float                      weight;
    private float                      height;
    private Float                      femaleRatio;
    private String                     variation;
    private int                        gen;
    private ValueText<UUID>            primaryType;
    private ValueText<UUID>            secondaryType;
    private List<TypeMultiplier>       attacking;
    private List<TypeMultiplier>       defending;
    private List<PokemonAbilityEntity> abilityList;
}
