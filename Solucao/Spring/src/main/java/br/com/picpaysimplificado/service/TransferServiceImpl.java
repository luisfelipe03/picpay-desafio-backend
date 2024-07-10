package br.com.picpaysimplificado.service;

import br.com.picpaysimplificado.controller.dto.TransferDto;
import br.com.picpaysimplificado.entity.Transfer;
import br.com.picpaysimplificado.entity.Wallet;
import br.com.picpaysimplificado.exception.InsufficientBalanceException;
import br.com.picpaysimplificado.exception.TransferNotAllowedForWalletTypeException;
import br.com.picpaysimplificado.exception.TransferNotAuthorizedException;
import br.com.picpaysimplificado.exception.WalletNotFoundException;
import br.com.picpaysimplificado.repository.TransferRepository;
import br.com.picpaysimplificado.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    NotificationService notificationService;
    @Autowired
    AuthorizationService authorizationService;
    @Autowired
    TransferRepository transferRepository;
    @Autowired
    WalletRepository walletRepository;


    @Override
    @Transactional
    public Transfer transfer(TransferDto transferDto) {

        var sender = walletRepository.findById(transferDto.payer())
            .orElseThrow(() -> new WalletNotFoundException(transferDto.payer()));

        var receiver = walletRepository.findById(transferDto.payee())
            .orElseThrow(() -> new WalletNotFoundException(transferDto.payee()));

        validateTranfer(transferDto, sender);

        sender.debit(transferDto.value());
        receiver.credit(transferDto.value());

        var transfer = new Transfer(sender, receiver, transferDto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));

        return transferResult;
    }

    private void validateTranfer(TransferDto transferDto, Wallet sender) {

        if (!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if (!sender.isBalanceEqualOrGreaterThan(transferDto.value())) {
            throw new InsufficientBalanceException();
        }

        if (!authorizationService.isAuthorized(transferDto)) {
            throw new TransferNotAuthorizedException();
        }
    }

}
