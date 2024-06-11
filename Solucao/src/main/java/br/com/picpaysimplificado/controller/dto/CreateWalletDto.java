package br.com.picpaysimplificado.controller.dto;

import br.com.picpaysimplificado.entity.Wallet;
import br.com.picpaysimplificado.entity.WalletType;

public record CreateWalletDto(String fullName,
                              String cpfCnpj,
                              String email,
                              String password,
                              WalletType.Enum walletType) {

    public Wallet toWallet() {
        return new Wallet(fullName, cpfCnpj, email, password, walletType.get());
    }
}
