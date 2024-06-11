package br.com.picpaysimplificado.controller;

import br.com.picpaysimplificado.controller.dto.CreateWalletDto;
import br.com.picpaysimplificado.entity.Wallet;
import br.com.picpaysimplificado.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<Wallet> createWallet(@RequestBody CreateWalletDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(walletService.createWallet(dto));
    }
}
