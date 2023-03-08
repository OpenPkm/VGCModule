package dev.cequell.openpkm.vgc_module.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValueText<T> {
    private T value;
    private String label;
}
