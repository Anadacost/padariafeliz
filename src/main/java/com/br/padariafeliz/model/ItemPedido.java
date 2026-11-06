package com.br.padariafeliz.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
@Getter
@Setter
@NoArgsConstructor
public class ItemPedido {

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
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "food_to_save_id")
    private FoodToSave foodToSave;

    public ItemPedido(Integer quantidade,
                      BigDecimal valorUnitario,
                      Pedido pedido,
                      Produto produto,
                      FoodToSave foodToSave) {

        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;

        this.subtotal = valorUnitario.multiply(
                BigDecimal.valueOf(quantidade)
        );

        this.pedido = pedido;
        this.produto = produto;
        this.foodToSave = foodToSave;
    }
}
