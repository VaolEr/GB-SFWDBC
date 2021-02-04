package ru.geekbrains.VaolEr.dao;


import org.springframework.stereotype.Repository;
import ru.geekbrains.VaolEr.config.EntityManagerConfig;
import ru.geekbrains.VaolEr.model.Buyer;
import ru.geekbrains.VaolEr.model.Product;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDAO {

    private final EntityManagerConfig entityManagerConfig;
    private EntityManager entityManager;

    public ProductDAO(EntityManagerConfig entityManagerConfig) {
        this.entityManagerConfig = entityManagerConfig;
        this.entityManager = this.entityManagerConfig.getEntityManager();
    }

    public boolean create( Product product){
        try{
            //Create
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(product);
            this.entityManager.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

     public Product findById(Long id){
        //Read
        //entityManager.getTransaction().begin();
        return this.entityManager.find(Product.class, id);
    }


    public List<Product> findAll(){
        this.entityManager.getTransaction().begin();
        List<Product> list = (List<Product>) this.entityManager.createQuery("SELECT p from Product p")
                .getResultList();
        this.entityManager.getTransaction().commit();
        return list;
    }

    public Product saveOrUpdate(Product product) {
        //Update
        this.entityManager.getTransaction().begin();
        Product productFromDb = findById(product.getId());
        productFromDb.setName(product.getName());
        productFromDb.setCost(product.getCost());
        this.entityManager.merge(productFromDb);
        this.entityManager.getTransaction().commit();
        return findById(product.getId());
    }

    public boolean delete(Product product){
        try {
            this.entityManager.getTransaction().begin();
            Product productFromDb = findById(product.getId());
            if(productFromDb.equals(null)){
                System.out.println("There is no product with id: " + product.getId());
                return false;
            } else {
                Query query = this.entityManager.createQuery("DELETE FROM Product p WHERE p.id = ?1");
                query.setParameter(1, productFromDb.getId()).executeUpdate();
                this.entityManager.getTransaction().commit();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            this.entityManager.getTransaction().commit();
            return false;
        }

    }

    public List<Buyer> findAllProductBuyersByProductId(Long productId){
        TypedQuery<Buyer> query = entityManager.createQuery("select b from Buyer b INNER JOIN Cart c ON (b.id =  c.buyer.id) WHERE c.product.id = ?1 group by b.id", Buyer.class);
        this.entityManager.getTransaction().begin();
        List<Buyer> list = query.setParameter(1, productId).getResultList();
        this.entityManager.getTransaction().commit();
        return list;
    }
}
