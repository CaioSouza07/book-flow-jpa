package com.domain.emprestimo;

import com.dao.BaseDAOImpl;
import com.domain.cliente.Cliente;
import com.domain.livro.Livro;
import com.util.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class EmprestimoDAO extends BaseDAOImpl<Emprestimo> {

    public List<Emprestimo> listarEmprestimosPorCliente(Cliente cliente){

        EntityManager em = EntityManagerUtil.getInstance().get();

        try{
            String query = "SELECT e FROM Emprestimo e WHERE e.cliente = :cliente";
            return em.createQuery(query, Emprestimo.class)
                    .setParameter("cliente", cliente)
                    .getResultList();
        }finally {
            em.close();
        }
    }

    public List<Emprestimo> listarEmprestimosPorLivroAtivos(Livro livro){

        EntityManager em = EntityManagerUtil.getInstance().get();

        try{
            String query = "SELECT e FROM Emprestimo e WHERE e.livro = :livro AND e.ativo = :ativo";
            return em.createQuery(query, Emprestimo.class)
                    .setParameter("livro", livro)
                    .setParameter("ativo", true)
                    .getResultList();
        }finally {
            em.close();
        }
    }

}
