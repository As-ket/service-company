package com.marketplace.companyservice.api.allEnums;

public enum TypeDocEnum {

    OGRNIP("Свидетельство ОГРНИП"),
    INN("Свидетельство ИНН"),
    PASSPORT("Копия паспорта");

    private final String type;

    TypeDocEnum(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
