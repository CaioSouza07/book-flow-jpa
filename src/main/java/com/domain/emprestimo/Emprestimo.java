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

    @ManyToOne
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

    @Column(nullable = false)
    private boolean ativo;

    public Emprestimo() {
    }

    public Emprestimo(Long id, Livro livro, Cliente cliente, LocalDate dataInicioEmprestimo, LocalDate dataFinalEmprestimo, boolean multaPaga, boolean ativo) {
        this.id = id;
        this.livro = livro;
        this.cliente = cliente;
        this.dataInicioEmprestimo = dataInicioEmprestimo;
        this.dataFinalEmprestimo = dataFinalEmprestimo;
        this.multaPaga = multaPaga;
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "| EMPRESTIMO ID: " + id + "\n" +
                "|--------------------------------|" + "\n" +
                "| * ID Livro: " + livro.getId() + "\n" +
                "| * Título Livro: " + livro.getTitulo() + "\n" +
                "| * ID Cliente: " + cliente.getId() + "\n" +
                "| * Nome cliente: " + cliente.getNome() + "\n" +
                "| * Ativo: " + ((ativo) ? "Sim" : "Não") + "\n" +
                "| * Multa paga: " + ((multaPaga) ? "Sim" : "Não") + "\n" +
                "|--------------------------------|";
    }

    public Livro getLivro() {
        return livro;
    }

    public Long getId() {
        return id;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataInicioEmprestimo() {
        return dataInicioEmprestimo;
    }

    public void setDataInicioEmprestimo(LocalDate dataInicioEmprestimo) {
        this.dataInicioEmprestimo = dataInicioEmprestimo;
    }

    public LocalDate getDataFinalEmprestimo() {
        return dataFinalEmprestimo;
    }

    public boolean isMultaPaga() {
        return multaPaga;
    }

    public void setMultaPaga(boolean multaPaga) {
        this.multaPaga = multaPaga;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setDataFinalEmprestimo(LocalDate dataFinalEmprestimo) {
        this.dataFinalEmprestimo = dataFinalEmprestimo;
    }


}
