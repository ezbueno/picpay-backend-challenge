package dev.ezandro.picpay.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "cpf_cnpj", unique = true)
    private String cpfCnpj;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "wallet_type_id")
    private WalletType walletType;

    public Wallet() {
    }

    public Wallet(Long id, String fullName, String cpfCnpj, String email, String password, BigDecimal balance, WalletType walletType) {
        this.id = id;
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.walletType = walletType;
    }

    public Wallet(String fullName, String cpfCnpj, String email, String password, WalletType walletType) {
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.walletType = walletType;
    }

    public Long getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpfCnpj() {
        return this.cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public WalletType getWalletType() {
        return this.walletType;
    }

    public void setWalletType(WalletType walletType) {
        this.walletType = walletType;
    }
}