package br.com.picpaysimplificado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAllowedForWalletTypeException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Transfer not allowed for wallet type");
        pb.setDetail("Transfer not allowed for wallet type");

        return pb;
    }
}
