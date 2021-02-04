package ru.geekbrains.VaolEr.dao;

import org.springframework.stereotype.Repository;
import ru.geekbrains.VaolEr.config.EntityManagerConfig;
import ru.geekbrains.VaolEr.model.Cart;
import ru.geekbrains.VaolEr.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CartDAO {

    private final EntityManagerConfig entityManagerConfig;
    private EntityManager entityManager;

    public CartDAO(EntityManagerConfig entityManagerConfig) {
        this.entityManagerConfig = entityManagerConfig;
        this.entityManager = this.entityManagerConfig.getEntityManager();
    }

    public Cart findById(Long id){
        //Read
        //entityManager.getTransaction().begin();
        return this.entityManager.find(Cart.class, id);
    }

    public List<Product> findAllBuyerProductsByBuyerId(Long buyerID){
        this.entityManager.getTransaction().begin();
        List<Product> list = (List<Product>) this.entityManager.createQuery("SELECT p from Product p")
                .getResultList();
        this.entityManager.getTransaction().commit();
        return list;
    }
}
