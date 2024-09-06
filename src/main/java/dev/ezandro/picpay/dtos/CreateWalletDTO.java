package dev.ezandro.picpay.dtos;

import dev.ezandro.picpay.entities.Wallet;
import dev.ezandro.picpay.enums.WalletTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDTO(@NotBlank String fullName,
                              @NotBlank String cpfCnpj,
                              @NotBlank String email,
                              @NotBlank String password,
                              @NotNull WalletTypeEnum walletTypeEnum) {

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