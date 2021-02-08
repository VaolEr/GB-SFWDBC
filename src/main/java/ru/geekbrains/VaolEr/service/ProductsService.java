package ru.geekbrains.VaolEr.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.VaolEr.model.Product;
import ru.geekbrains.VaolEr.repository.ProductsRepository;

@Service
@RequiredArgsConstructor
public class ProductsService {

    //private final ProductsRepository productsRepository;

    private final ProductsRepository productsRepository;

    public static Map<Long, Product> products = new HashMap<>();

    static {
        Product product1 = new Product();
        product1.setId(0L);
        product1.setName("Product 1");
        product1.setCost(22.50);
        products.put(product1.getId(), product1);

        Product product2 = new Product();
        product2.setId(1L);
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
        product.setId((long)++productsCount);
        products.put(product.getId(),product);
    }



    public Page<Product> findPaginated(Pageable pageable) {
        List<Product> products8 = productsRepository.findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> list;

        if (products8.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, products8.size());
            list = products8.subList(startItem, toIndex);
        }

        Page<Product> productPage
                = new PageImpl<Product>(list, PageRequest.of(currentPage, pageSize), products8.size());

        return productPage;
    }
}
