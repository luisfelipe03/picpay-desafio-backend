package br.com.picpaysimplificado.repository;

import br.com.picpaysimplificado.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
