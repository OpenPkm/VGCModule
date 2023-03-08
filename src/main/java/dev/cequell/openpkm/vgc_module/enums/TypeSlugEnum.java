package dev.cequell.openpkm.vgc_module.enums;

import lombok.Getter;

import java.util.UUID;

public enum TypeSlugEnum {
    BUG("57f65056-6a64-45b5-8649-02b96e009ac9", "Bug"),
    DRK("5f21849a-6fa5-45d2-b1e2-ada97215888a", "Dark"),
    DRG("0e33fdd1-4f75-4c96-96b8-555e8391c314", "Dragon"),
    ELT("e35d733d-7e34-44ab-881d-2c68c86124f8", "Electric"),
    FAI("ecfa8f98-c29a-4c06-845a-8a5c57b4998c", "Fairy"),
    FGT("046a843a-6823-4d2c-8983-19d5ba38ebe0", "Fighting"),
    FIR("b2284eab-586c-4320-ae6f-cc6db0cd60ea", "Fire"),
    FLY("dcf324c1-9e37-4696-bef1-a513afc754e1", "Flying"),
    GHO("73015e8d-d4a7-4a26-9b8b-24cb1d44fd2d", "Ghost"),
    GRS("604d2a58-230b-4c4b-a113-26619bbf6244", "Grass"),
    GRN("36e42846-b4f0-4d1e-96b9-3a66122b8251", "Ground"),
    ICE("f89e14b1-ed09-4ec7-9b91-3e0b96555d0b", "Ice"),
    NOR("1657c673-c6df-4116-9a1e-6f3734bb7f69", "Normal"),
    PSN("34df4853-382f-4c81-9dc0-a43e03d26eb6", "Poison"),
    PSY("c6e06e6c-49d3-48d6-8fd4-e8abd0133bb2", "Psychic"),
    RCK("a4c89b29-18bc-4518-ad57-90035fde8f1a", "Rock"),
    STE("0f88ad49-808a-4d14-81fd-fbf7d951734b", "Steel"),
    WAT("7f5031c0-e075-4d0b-8320-a91b209e442c", "Water");

    @Getter
    private final UUID value;

    @Getter
    private final String label;

    TypeSlugEnum(final String value, final String label) {
        this.value = UUID.fromString(value);
        this.label = label;
    }

    public static TypeSlugEnum from(final UUID type) {
        for(var cur : TypeSlugEnum.values()) {
            if(cur.value == type) return cur;
        }
        return null;
    }
}
