package br.com.picpaysimplificado.repository;

import br.com.picpaysimplificado.entity.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
