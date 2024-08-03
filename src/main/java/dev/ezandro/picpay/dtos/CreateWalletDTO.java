package dev.ezandro.picpay.dtos;

import dev.ezandro.picpay.entities.Wallet;
import dev.ezandro.picpay.enums.WalletTypeEnum;

public record CreateWalletDTO(String fullName,
                              String cpfCnpj,
                              String email,
                              String password,
                              WalletTypeEnum walletTypeEnum) {

    public Wallet toWallet() {
        return new Wallet(
                this.fullName,
                this.cpfCnpj,
                this.email,
                this.password,
                this.walletTypeEnum().toWalletType()
        );
    }
}