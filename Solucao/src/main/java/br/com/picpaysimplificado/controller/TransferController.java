package br.com.picpaysimplificado.controller;

import br.com.picpaysimplificado.controller.dto.TransferDto;
import br.com.picpaysimplificado.entity.Transfer;
import br.com.picpaysimplificado.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDto dto) {
        var resp = transferService.transfer(dto);

        return ResponseEntity.ok(resp);
    }
}
