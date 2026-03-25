package com.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerUtil instance;
    private EntityManagerFactory emf;

    private EntityManagerUtil() {
        emf = Persistence.createEntityManagerFactory("bookflowPU");
    }

    public static EntityManagerUtil getInstance() {
        if (instance == null) {
            instance = new EntityManagerUtil();
        }
        return instance;
    }

    public EntityManager get() {
        return emf.createEntityManager();
    }
}

