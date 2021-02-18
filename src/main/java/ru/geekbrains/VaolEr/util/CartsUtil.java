package ru.geekbrains.VaolEr.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.geekbrains.VaolEr.dto.CartTo;
import ru.geekbrains.VaolEr.dto.CustomerTo;
import ru.geekbrains.VaolEr.model.Cart;
import ru.geekbrains.VaolEr.model.Customer;

import java.util.List;
import java.util.stream.Collectors;

import static ru.geekbrains.VaolEr.util.BuyersUtil.fromBuyerTo;
import static ru.geekbrains.VaolEr.util.BuyersUtil.toBuyerTo;
import static ru.geekbrains.VaolEr.util.ProductsUtil.fromProductTo;
import static ru.geekbrains.VaolEr.util.ProductsUtil.toProductTo;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartsUtil {
    //This class transforms model entity to JSON transferred entity
    // and to the other side

    public static CartTo toCartTo(Cart cart) {
        assert cart.getId() != null;
        return CartTo
                .builder()
                .id(cart.getId())
                .buyerTo(toBuyerTo(cart.getBuyer()))
                .productTo(toProductTo(cart.getProduct()))
                .build();
    }

    public static List<CartTo> toCartTos(List<Cart> carts) {
        return carts.stream().map(CartsUtil::toCartTo).collect(Collectors.toList());
    }

    public static Cart fromCartTo(CartTo cartTo) {
        Cart newCart = new Cart();
        newCart.setId(cartTo.getId());
        newCart.setBuyer(fromBuyerTo(cartTo.getBuyerTo()));
        newCart.setProduct(fromProductTo(cartTo.getProductTo()));
        return newCart;
    }
}
