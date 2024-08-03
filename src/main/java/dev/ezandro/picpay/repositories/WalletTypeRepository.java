package dev.ezandro.picpay.repositories;

import dev.ezandro.picpay.entities.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}