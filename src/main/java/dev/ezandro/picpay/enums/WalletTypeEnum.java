package dev.ezandro.picpay.enums;

import dev.ezandro.picpay.entity.WalletType;

public enum WalletTypeEnum {
    USER(1L, "user"),
    MERCHANT(2L, "merchant");

    private final Long id;
    private final String description;

    WalletTypeEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public WalletType toWalletType() {
        return new WalletType(this.id, this.description);
    }
}