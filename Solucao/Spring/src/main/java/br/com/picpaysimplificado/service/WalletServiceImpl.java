package br.com.picpaysimplificado.service;

import br.com.picpaysimplificado.controller.dto.CreateWalletDto;
import br.com.picpaysimplificado.entity.Wallet;
import br.com.picpaysimplificado.exception.WalletDataAlreadyExistsException;
import br.com.picpaysimplificado.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository repository;

    @Override
    public Wallet createWallet(CreateWalletDto dto) {

        var walletDB = repository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (walletDB.isPresent()) {
            throw new WalletDataAlreadyExistsException("CPF/CNPJ or email already exists.");
        }
        return repository.save(dto.toWallet());
    }
}
