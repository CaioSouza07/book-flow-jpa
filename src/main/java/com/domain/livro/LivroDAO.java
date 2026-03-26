package com.domain.livro;

import com.dao.BaseDAOImpl;
import com.util.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class LivroDAO extends BaseDAOImpl<Livro> {

    public List<Livro> listarLivros(){

        EntityManager em = EntityManagerUtil.getInstance().get();

        try{
            String query = "SELECT l FROM Livro l";
            return em.createQuery(query, Livro.class).getResultList();
        }finally {
            em.close();
        }

    }
}
