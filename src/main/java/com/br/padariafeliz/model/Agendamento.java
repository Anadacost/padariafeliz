package com.br.padariafeliz.model;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter
@NoArgsConstructor
public class Agendamento {

    public enum Status {
        PENDENTE,
        ACEITO,
        RECUSADO,
        CANCELADO,
        CONCLUIDO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataAgendamento;

    @Column(nullable = false)
    private LocalDateTime dataRetirada;

    @Column(length = 500)
    private String observacoes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDENTE;

    @Column(precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "agendamento",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ItemAgendamento> itens = new ArrayList<>();

    public Agendamento(Cliente cliente,
                       LocalDateTime dataRetirada,
                       String observacoes) {

        this.cliente = cliente;
        this.dataRetirada = dataRetirada;
        this.observacoes = observacoes;
        this.dataAgendamento = LocalDateTime.now();
        this.status = Status.PENDENTE;
        this.valorTotal = BigDecimal.ZERO;
    }
}
