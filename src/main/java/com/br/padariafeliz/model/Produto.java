package com.br.padariafeliz.model;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    private String imagem;

    private Integer quantidadeEstoque;

    private LocalDateTime dataCadastro;

    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    public Produto(String codigo, String nome,
                   String descricao, BigDecimal valor,
                   String imagem, Integer quantidadeEstoque,
                   Categoria categoria) {

        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
        this.dataCadastro = LocalDateTime.now();
        this.ativo = true;
    }
}
