package dev.cequell.openpkm.vgc_module.enums;

import lombok.Getter;

import java.util.UUID;

public enum TypeChartGenerationEnum {
    GEN_I("e5878a9d-726c-43fc-b10a-4353f6825927"),
    GEN_II_V("b90a1c2f-a0e2-4e39-bf89-f74cd6c300ba"),
    GEN_VI_ONWARD("92844b2e-dcce-42e8-82b3-1dee36c40253");

    @Getter
    private final UUID value;

    TypeChartGenerationEnum(final String value) {
        this.value = UUID.fromString(value);
    }
}
