package br.com.picpaysimplificado.config;

import br.com.picpaysimplificado.entity.WalletType;
import br.com.picpaysimplificado.repository.WalletTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private WalletTypeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletType.Enum.values())
            .forEach(walletType -> repository.save(walletType.getWalletType()));
    }
}
