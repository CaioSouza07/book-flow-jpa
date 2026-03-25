package com.dao;

import com.util.EntityManagerUtil;
import javax.persistence.EntityManager;

public abstract class BaseDAOImpl<T> implements BaseDAO<T>{

    @Override
    public void salvar(T entity) {

        EntityManager em = EntityManagerUtil.getInstance().get();

        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive() && em.getTransaction() != null){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro: " + e.getMessage());
        } finally {
            em.close();
        }

    }

    @Override
    public T buscarPorId(Class<T> entityClass, Long id) {

        EntityManager em = EntityManagerUtil.getInstance().get();

        try{
            return em.find(entityClass, id);
        } finally {
            em.close();
        }

    }

    @Override
    public void deletar(T entity) {

        EntityManager em = EntityManagerUtil.getInstance().get();

        try{
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive() && em.getTransaction() != null){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro: " + e.getMessage());
        } finally {
            em.close();
        }

    }

    @Override
    public void atualizar(T entity) {

        EntityManager em = EntityManagerUtil.getInstance().get();

        try{
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive() && em.getTransaction() != null){
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro: " + e.getMessage());
        } finally {
            em.close();
        }

    }
}
