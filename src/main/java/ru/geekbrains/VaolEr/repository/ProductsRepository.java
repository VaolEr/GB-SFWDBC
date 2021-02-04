package ru.geekbrains.VaolEr.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.VaolEr.model.Product;

@Transactional(readOnly = true)
public interface ProductsRepository {

    List<Product> getAllProducts();
    Product getProductById(Integer id);
}
