package ru.geekbrains.VaolEr.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.VaolEr.model.Product;
import ru.geekbrains.VaolEr.repository.ProductsRepository;

@Service
@RequiredArgsConstructor
public class ProductsService {

    //private final ProductsRepository productsRepository;

    public static Map<Integer, Product> products = new HashMap<>();

    static {
        Product product1 = new Product();
        product1.setId(0);
        product1.setName("Product 1");
        product1.setCost(22.50);
        products.put(product1.getId(), product1);

        Product product2 = new Product();
        product2.setId(1);
        product2.setName("Product 2");
        product2.setCost(42.50);
        products.put(product2.getId(), product2);
    }


    public List<Product> getAllProducts(){
        List<Product> prodList = new ArrayList<>(products.values());
        Collections.sort(prodList);
        return prodList;
    }

    public Product getProductById(Integer id){
        return products.get(id);
    }

    public void save(Product product){
        int productsCount = products.size();
        product.setId(++productsCount);
        products.put(product.getId(),product);
    }
}
