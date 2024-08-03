package dev.ezandro.picpay.services;

import dev.ezandro.picpay.dtos.CreateWalletDTO;
import dev.ezandro.picpay.entities.Wallet;
import dev.ezandro.picpay.exceptions.WalletDataAlreadyExistsException;
import dev.ezandro.picpay.repositories.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDTO createWalletDTO) {
        var existingWallet = this.walletRepository.findByCpfCnpjOrEmail(createWalletDTO.cpfCnpj(), createWalletDTO.email());

        if(existingWallet.isPresent()) {
            throw new WalletDataAlreadyExistsException("A wallet with the given CPF/CNPJ or Email already exists.");
        }

        return this.walletRepository.save(createWalletDTO.toWallet());
    }
}