package ru.geekbrains.VaolEr.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.VaolEr.model.Product;

@Transactional(readOnly = true)
public interface ProductsRepository extends JpaRepository<Product, Long> {

    //In this class we are work with DB

    //List<Product> getAllProducts();

    List<Product> findByNameContaining(String name);

    Product getProductById(Long id);
}
