package dev.cequell.openpkm.vgc_module.models;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeMultiplier {
    private UUID typeId;
    private String typeName;
    private String typeSlug;
    private double multiplier;
}
