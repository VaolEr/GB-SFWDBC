package ru.geekbrains.VaolEr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import ru.geekbrains.VaolEr.model.Product;
import ru.geekbrains.VaolEr.repository.ProductRepository;

@Controller
public class Cart {

    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    List<Product> cartProducts = new ArrayList<>();

    public void addAllProductsToCart(){
        cartProducts.addAll(productRepository.getAllProducts());
    }

    public void addProductToCart(Integer productId){
        cartProducts.add(productRepository.getProductById(productId));
    }

    public void deleteProductFromCart(Integer productId){
        for (int i = 0; i < cartProducts.size(); i++) {
            if(cartProducts.get(i).getId().equals(productId)){
                cartProducts.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Product p:cartProducts) {
            stringBuilder.append(String.format("{Product: id: %d, name: %s, cost: %f};\n",p.getId(),p.getName(),p.getCost()));
        }
        return stringBuilder.toString();
    }
}
