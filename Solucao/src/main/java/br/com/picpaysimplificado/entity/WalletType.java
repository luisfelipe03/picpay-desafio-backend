package br.com.picpaysimplificado.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_wallet_type")
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    public WalletType() {
    }

    public WalletType(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Enum {
        USER(1, "USER"),
        MERCHANT(2, "Merchant");

        private  long id;
        private  String description;

        Enum(long id, String description) {
            this.id = id;
            this.description = description;
        }

        public long getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public WalletType getWalletType() {
            return new WalletType(id, description);
        }
    }
}
