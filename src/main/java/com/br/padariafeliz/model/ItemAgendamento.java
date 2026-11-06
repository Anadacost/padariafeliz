package com.br.padariafeliz.model;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_agendamento")
@Getter
@Setter
@NoArgsConstructor
public class ItemAgendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorUnitario;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "agendamento_id", nullable = false)
    private Agendamento agendamento;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    public ItemAgendamento(Integer quantidade,
                           BigDecimal valorUnitario,
                           Agendamento agendamento,
                           Produto produto) {

        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.subtotal = valorUnitario.multiply(
                BigDecimal.valueOf(quantidade)
        );
        this.agendamento = agendamento;
        this.produto = produto;
    }
}
