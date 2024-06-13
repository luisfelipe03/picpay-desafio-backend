package br.com.picpaysimplificado.service;

import br.com.picpaysimplificado.entity.Transfer;

public interface AuthorizationService {

    boolean isAuthorized(Transfer transfer);
}
