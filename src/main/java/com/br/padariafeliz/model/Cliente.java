package com.br.padariafeliz.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Usuario {

    @Column(unique = true, length = 14)
    private String cpf;

    @Column(length = 150)
    private String endereco;

    @Column(length = 80)
    private String bairro;

    @Column(length = 80)
    private String cidade;

    @Column(length = 10)
    private String cep;

    public Cliente(String nome, String email, String senha,
                   String telefone, String cpf,
                   String endereco, String bairro,
                   String cidade, String cep) {

        super(nome, email, senha, telefone);

        this.cpf = cpf;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }
}
