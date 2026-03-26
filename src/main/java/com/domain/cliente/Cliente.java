package com.domain.cliente;

import com.domain.emprestimo.Emprestimo;
import com.exception.RegraDeNegocioException;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Emprestimo> listaEmprestimos;


    public Cliente() {
    }

    public Cliente(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "| CLIENTE ID: " + id + "\n" +
                "|--------------------------------|" + "\n" +
                "| * Nome: " + nome + "\n" +
                "| * E-mail: " + email + "\n" +
                "|--------------------------------|";
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if(email.matches(regex)){
            this.email = email;
        }else {
            throw new RegraDeNegocioException("[E-mail com formato inválido!]");
        }

    }

    public String getEmail() {
        return email;
    }

}
