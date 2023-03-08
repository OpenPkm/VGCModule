package dev.cequell.openpkm.vgc_module.enums;

import lombok.Getter;

import java.util.UUID;

public enum GenerationEnum {
    Gen_I("379d54a3-aad5-4c64-87ff-b0db89666de0"),
    Gen_II("0a35e22d-e3a9-42d3-9c13-eef777f385d6"),
    Gen_III("bb1568a7-0594-4812-9345-955b6c0d40aa"),
    Gen_IV("889e7640-d182-40ad-ab33-d314613f4829"),
    Gen_V("a8a8a689-c93a-457f-8835-48e0df017883"),
    Gen_VI("cfe277d0-a625-46bb-a0b0-479c39c595a7"),
    Gen_VII("3c34491f-8737-4542-b1c6-da9c2afdbb83"),
    Gen_VIII("b92e86b5-2aa3-44be-b2af-574ce8487ede"),
    Gen_IX("7352b9ab-cf24-4272-8b9d-b28824d6e4d6");

    @Getter
    private final UUID value;

    GenerationEnum(final String value) {
        this.value = UUID.fromString(value);
    }
}
