package ru.geekbrains.VaolEr;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import ru.geekbrains.VaolEr.model.Product;
import ru.geekbrains.VaolEr.service.ProductsService;

@Controller
public class Cart {

    private final ProductsService productsService;

    public Cart(ProductsService productsService) {
        this.productsService = productsService;
    }

    List<Product> cartProducts = new ArrayList<>();

    public void addAllProductsToCart(){
        cartProducts.addAll(productsService.getAllProducts());
    }

    public void addProductToCart(Integer productId){
        cartProducts.add(productsService.getProductById(productId));
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
        if(cartProducts.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Product p : cartProducts) {
                stringBuilder.append(String.format("{Product: id: %d, name: %s, cost: %f};\n",
                                                   p.getId(), p.getName(), p.getCost()));
            }
            return stringBuilder.toString();
        }
        else{
            return "Cart is empty!";
        }
    }
}
