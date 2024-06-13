package br.com.picpaysimplificado.service;

import br.com.picpaysimplificado.controller.dto.TransferDto;

public interface AuthorizationService {

    boolean isAuthorized(TransferDto transfer);
}
