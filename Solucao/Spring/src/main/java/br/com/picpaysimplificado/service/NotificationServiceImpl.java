package br.com.picpaysimplificado.service;


import br.com.picpaysimplificado.client.NotificationClient;
import br.com.picpaysimplificado.entity.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Autowired
    private NotificationClient notificationClient;

    @Override
    public void sendNotification(Transfer transfer) {

        try {
            logger.info("Notification sent");
            var resp = notificationClient.sendNotification(transfer);

            if (resp.getStatusCode().isError()) {
                logger.error("Error sending notification");
            }

        } catch (Exception e) {
            logger.error("Error sending notification", e);
        }

    }
}

