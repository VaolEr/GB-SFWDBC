package ru.geekbrains.VaolEr.config;

import lombok.Getter;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Getter
@Component
public class EntityManagerConfig {


    private EntityManager entityManager;
    private EntityManagerFactory factory;

    public EntityManagerConfig(){
        factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();
        entityManager = factory.createEntityManager();
    }
}
