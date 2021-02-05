package ru.geekbrains.VaolEr.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.geekbrains.VaolEr.dto.ProductTo;
import ru.geekbrains.VaolEr.model.Product;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductsUtil {

    //This class transforms model entity to JSON transferred entity
    // and to the other side

    public static ProductTo toProductTo(Product product) {
        return ProductTo
                .builder()
                .id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .build();
    }

    public static List<ProductTo> toProductTos(List<Product> products) {
        return products.stream().map(ProductsUtil::toProductTo).collect(Collectors.toList());
    }

    public static Product fromProductTo(ProductTo productTo) {
        Product newProduct = new Product();
        newProduct.setId(productTo.getId());
        newProduct.setName(productTo.getName());
        newProduct.setCost(productTo.getCost());
        return newProduct;
    }
}
