package ru.geekbrains.VaolEr.service;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.VaolEr.dto.ProductTo;
import ru.geekbrains.VaolEr.model.Product;
import ru.geekbrains.VaolEr.repository.ProductsRepository;

import java.util.List;
import static org.springframework.util.StringUtils.hasText;
import static ru.geekbrains.VaolEr.util.ProductsUtil.fromProductTo;

@Service
@RequiredArgsConstructor
public class ProductRestService {

    private final ProductsRepository productsRepository;

    public List<Product> get(String name){
        return hasText(name) ? productsRepository.findByNameContaining(name)
                : productsRepository.findAll();
    }

    public List<Product> getWitMoreThanMinCost(String name, Double minCost){
        return hasText(name) ? productsRepository.findByNameContainingAndCostGreaterThan(name, minCost) : productsRepository.findAllByCostGreaterThan(minCost);
    }

    public List<Product> getWitLessThanMaxCost(String name, Double maxCost){
        return hasText(name) ? productsRepository.findByNameContainingAndCostLessThan(name, maxCost) : productsRepository.findAllByCostLessThan(maxCost);
    }

    public List<Product> getWitCostBetweenMinAndMax(String name, Double minCost, Double maxCost){
        return hasText(name) ? productsRepository.findByNameContainingAndCostBetween(name, minCost, maxCost) : productsRepository.findAllByCostBetween(minCost, maxCost);
    }

    public Product getById(Long id) throws NotFoundException {
        //тут по-хорошему нужно ещё сделать проверку на наличие данных в базе
        return productsRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found entity with"));
    }

    public Product create(ProductTo productTo) {
        Product newProduct = fromProductTo(productTo);
        return productsRepository.save(newProduct);
    }

    @Transactional
    public void delete(Long id) {
        productsRepository.deleteById(id);
    }
}
