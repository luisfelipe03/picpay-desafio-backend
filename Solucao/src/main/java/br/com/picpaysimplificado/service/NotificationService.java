package br.com.picpaysimplificado.service;

import br.com.picpaysimplificado.entity.Transfer;

public interface NotificationService {

    void sendNotification(Transfer transfer);
}
