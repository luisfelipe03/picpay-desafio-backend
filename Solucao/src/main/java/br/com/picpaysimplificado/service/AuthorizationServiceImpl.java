package br.com.picpaysimplificado.service;

import br.com.picpaysimplificado.client.AuthorizationClient;
import br.com.picpaysimplificado.entity.Transfer;
import br.com.picpaysimplificado.exception.PicPayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    AuthorizationClient authorizationClient;

    public boolean isAuthorized(Transfer transfer) {
       var resp = authorizationClient.isAuthorized();

       if(resp.getStatusCode().isError()) {
           throw new PicPayException();
       }

       return resp.getBody().authorized();
    }


}
