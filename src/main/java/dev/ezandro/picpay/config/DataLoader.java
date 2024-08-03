package dev.ezandro.picpay.config;

import dev.ezandro.picpay.enums.WalletTypeEnum;
import dev.ezandro.picpay.repositories.WalletTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {
    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.walletTypeRepository.count() == 0) {
            Arrays.stream(WalletTypeEnum.values())
                    .map(WalletTypeEnum::toWalletType)
                    .forEach(this.walletTypeRepository::save);
        }
    }
}
