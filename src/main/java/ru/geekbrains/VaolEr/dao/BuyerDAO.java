package ru.geekbrains.VaolEr.dao;

import org.springframework.stereotype.Repository;
import ru.geekbrains.VaolEr.config.EntityManagerConfig;
import ru.geekbrains.VaolEr.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BuyerDAO {

    private final EntityManagerConfig entityManagerConfig;
    private EntityManager entityManager;

    public BuyerDAO(EntityManagerConfig entityManagerConfig) {
        this.entityManagerConfig = entityManagerConfig;
        this.entityManager = this.entityManagerConfig.getEntityManager();
    }

    public List<Product> findAllBuyerProductsByBuyerId(Long buyerId){
        TypedQuery<Product> query = entityManager.createQuery(
                "select p from Product p \n" +
                        "\tINNER JOIN Cart c ON (p.id =  c.product.id)\n" +
                        "WHERE c.buyer.id = ?1", Product.class);
        this.entityManager.getTransaction().begin();
        List<Product> list = query.setParameter(1, buyerId).getResultList();
        this.entityManager.getTransaction().commit();
        return list;
    }

}
