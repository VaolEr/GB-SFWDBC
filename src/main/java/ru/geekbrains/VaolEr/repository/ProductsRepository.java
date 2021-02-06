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

    List<Product> findByNameContainingAndCostGreaterThan(String name, Double minCost);

    List<Product> findAllByCostGreaterThan(Double minCost);

    List<Product> findByNameContainingAndCostLessThan(String name, Double maxCost);

    List<Product> findAllByCostLessThan(Double maxCost);

    List<Product> findByNameContainingAndCostBetween(String name, Double minCost, Double maxCost);

    List<Product> findAllByCostBetween(Double minCost, Double maxCost);

    Product getProductById(Long id);

}
