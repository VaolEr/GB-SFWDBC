package ru.geekbrains.VaolEr.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import ru.geekbrains.VaolEr.model.Product;

@Component
public class ProductRepository {

    public static Map<Integer, Product> products = new HashMap<>();

//    static {
//        Product product1 = new Product();
//        product1.setId(0);
//        product1.setName("Prod1");
//        product1.setCost(22.50);
//        products.put(product1.getId(), product1);
//
//        Product product2 = new Product();
//        product2.setId(1);
//        product2.setName("Prod2");
//        product2.setCost(47.47);
//        products.put(product2.getId(), product2);
//
//        Product product3 = new Product();
//        product3.setId(2);
//        product3.setName("Prod2");
//        product3.setCost(85.30);
//        products.put(product3.getId(), product3);
//
//        Product product4 = new Product();
//        product4.setId(3);
//        product4.setName("Prod2");
//        product4.setCost(39.22);
//        products.put(product4.getId(), product4);
//
//        Product product5 = new Product();
//        product5.setId(4);
//        product5.setName("Prod2");
//        product5.setCost(17.56);
//        products.put(product5.getId(), product5);
//
//    }

    public List<Product> getAllProducts(){
        return new ArrayList<>(products.values());
    }

    public Product getProductById(Integer id){
        return products.get(id);
    }
}
