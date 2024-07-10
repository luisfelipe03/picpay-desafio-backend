package br.com.picpaysimplificado.service;

import br.com.picpaysimplificado.controller.dto.CreateWalletDto;
import br.com.picpaysimplificado.entity.Wallet;

public interface WalletService {

    public Wallet createWallet(CreateWalletDto dto);
}
