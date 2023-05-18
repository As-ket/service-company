package com.marketplace.companyservice.api.allEnums;

public enum FormatDocEnum {

    PDF("pdf"),
    JPEG("jpeg"),
    PNG("png");

    private final String format;

    FormatDocEnum(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return format;
    }
}