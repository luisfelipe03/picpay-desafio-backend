package br.com.picpaysimplificado.service;

import br.com.picpaysimplificado.controller.dto.TransferDto;
import br.com.picpaysimplificado.entity.Transfer;

public interface TransferService {


    Transfer transfer(TransferDto dto);
}
