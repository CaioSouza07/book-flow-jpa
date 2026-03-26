package com.domain.emprestimo;

import com.domain.cliente.Cliente;
import com.domain.livro.Livro;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDate dataInicioEmprestimo;

    @Column(nullable = false)
    private LocalDate dataFinalEmprestimo;

    private boolean multaPaga;

    public Emprestimo() {
    }

    public Emprestimo(Long id, Livro livro, Cliente cliente, LocalDate dataInicioEmprestimo, LocalDate dataFinalEmprestimo, boolean multaPaga) {
        this.id = id;
        this.livro = livro;
        this.cliente = cliente;
        this.dataInicioEmprestimo = dataInicioEmprestimo;
        this.dataFinalEmprestimo = dataFinalEmprestimo;
        this.multaPaga = multaPaga;
    }

    public Livro getLivro() {
        return livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataInicioEmprestimo() {
        return dataInicioEmprestimo;
    }

    public LocalDate getDataFinalEmprestimo() {
        return dataFinalEmprestimo;
    }

    public boolean isMultaPaga() {
        return multaPaga;
    }

    public void setDataFinalEmprestimo(LocalDate dataFinalEmprestimo) {
        this.dataFinalEmprestimo = dataFinalEmprestimo;
    }

    public void setMultaPaga(boolean multaPaga) {
        this.multaPaga = multaPaga;
    }
}
