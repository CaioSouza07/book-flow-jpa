package com.domain.livro;

import com.dao.BaseDAOImpl;
import com.util.EntityManagerUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class LivroDAO extends BaseDAOImpl<Livro> {

    public List<Livro> listarLivrosDisponiveis(){

        EntityManager em = EntityManagerUtil.getInstance().get();

        try{
            String query = "SELECT l FROM Livro l WHERE l.disponivel = :paramDisponivel";
            return em.createQuery(query, Livro.class)
                    .setParameter("paramDisponivel", true)
                    .getResultList();
        }finally {
            em.close();
        }

    }

}
