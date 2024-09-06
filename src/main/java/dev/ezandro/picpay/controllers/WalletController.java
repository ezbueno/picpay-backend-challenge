package dev.ezandro.picpay.controllers;

import dev.ezandro.picpay.dtos.CreateWalletDTO;
import dev.ezandro.picpay.entities.Wallet;
import dev.ezandro.picpay.services.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping(value = "/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDTO createWalletDTO) {
        var wallet = this.walletService.createWallet(createWalletDTO);
        return ResponseEntity.created(URI.create("/wallets/" + wallet.getId())).body(wallet);
    }
}