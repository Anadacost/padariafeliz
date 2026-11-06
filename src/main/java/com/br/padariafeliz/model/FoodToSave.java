package com.br.padariafeliz.model;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "food_to_save")
@Getter
@Setter
@NoArgsConstructor
public class FoodToSave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private Integer quantidadeDisponivel;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataValidade;

    private Boolean ativo = true;

    public FoodToSave(String nome,
                      String descricao,
                      BigDecimal valor,
                      Integer quantidadeDisponivel,
                      LocalDateTime dataValidade) {

        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.dataValidade = dataValidade;
        this.dataCadastro = LocalDateTime.now();
        this.ativo = true;
    }
}
