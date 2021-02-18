package ru.geekbrains.VaolEr.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.geekbrains.VaolEr.dao.BuyerDAO;
import ru.geekbrains.VaolEr.dao.ProductDAO;

@Component
public class Runner implements CommandLineRunner {

    private final ProductDAO productDAO;
    private final BuyerDAO buyerDAO;

    public Runner(ProductDAO productDAO, BuyerDAO buyerDAO) {
        this.productDAO = productDAO;
        this.buyerDAO = buyerDAO;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(productDAO.findById(1L).toString());

        System.out.println(productDAO.findAllProductBuyersByProductId(4L).toString());

        productDAO.findAll().forEach(product -> System.out.println(product.toString()));

        //Сервис, позволяющий по id товара узнавать список покупателей этого товара
        productDAO.findAllProductBuyersByProductId(4L).forEach(buyer -> System.out.println(buyer.toString()));

        //Сервис, позволяющий по id покупателя узнать список купленных им товаров
        buyerDAO.findAllBuyerProductsByBuyerId(1L).forEach(product -> System.out.println(product.toString()));

    }
}
