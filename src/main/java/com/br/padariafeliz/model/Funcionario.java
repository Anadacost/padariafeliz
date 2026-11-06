package com.br.padariafeliz.model;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "funcionarios")
@Getter
@Setter
@NoArgsConstructor
public class Funcionario extends Usuario {

    @Column(nullable = false, length = 60)
    private String cargo;

    @Column(length = 20)
    private String matricula;

    public Funcionario(String nome, String email, String senha,
                       String telefone, String cargo,
                       String matricula) {

        super(nome, email, senha, telefone);

        this.cargo = cargo;
        this.matricula = matricula;
    }
}
