package ru.geekbrains.VaolEr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GB_SFWDBC_Application {

//    static final String STOP_COMMAND = "STOP";
//    static final String CLEAN_COMMAND = "CLEAN";
//    static final String PRINT_COMMAND = "PRINT";
//    static final String ADD_TO_CART_COMMAND = "ADD";
//    static final String ADD_ALL_TO_CART_COMMAND = "ADDALL";
//    static final String REMOVE_FROM_CART_COMMAND = "REMOVE";
//    static final String REMOVE_FROM_COUNT_COMMAND = "COUNT";

    public static void main(String[] args) {
        SpringApplication.run(GB_SFWDBC_Application.class, args);
//        Product product1 = new Product();
//        product1.setId(0);
//        product1.setName("Prod1");
//        product1.setCost(22.50);
//        ProductRepository.products.put(product1.getId(), product1);
//
//        Product product2 = new Product();
//        product2.setId(1);
//        product2.setName("Prod2");
//        product2.setCost(47.47);
//        ProductRepository.products.put(product2.getId(), product2);
//
//        Product product3 = new Product();
//        product3.setId(2);
//        product3.setName("Prod2");
//        product3.setCost(85.30);
//        ProductRepository.products.put(product3.getId(), product3);
//
//        Product product4 = new Product();
//        product4.setId(3);
//        product4.setName("Prod2");
//        product4.setCost(39.22);
//        ProductRepository.products.put(product4.getId(), product4);
//
//        Product product5 = new Product();
//        product5.setId(4);
//        product5.setName("Prod2");
//        product5.setCost(17.56);
//        ProductRepository.products.put(product5.getId(), product5);
//
//        Cart cart = new Cart(new ProductRepository());
//
//        try (BufferedReader bufferedReader = new
//            BufferedReader(new InputStreamReader(System.in))) {
//            Thread
//                .sleep(1000); //Для того, чтоб программа работала после полной инициализации спринга
//            System.out.println("\nДобро пожаловать!\n"
//                                   + "Для выхода из программы введите STOP.\n"
//                                   + "Для добавления товаров в корзину введите команду ADD и затем id от 0 до 4.\n"
//                                   + "Для добавления всех товаров в корзину введите команду ADDALL.\n"
//                                   + "Для удаления товаровов с конкретным ID из корзины введите команду REMOVE и затем id от 0 до 4.\n"
//                                   + "Для очистки корзины введите CLEAN.\n"
//                                   + "Для отображения содержимого корзины введите PRINT.\n"
//                                   + "Для отображения количества элементов в корзине введите COUNT.");
//            String command = "";
//            while (!command.equals(STOP_COMMAND)) {
//                command = bufferedReader.readLine().toUpperCase(Locale.ROOT);
//                int gotId;
//                switch (command) {
//                    case CLEAN_COMMAND:
//                        for (int i = cart.cartProducts.size()-1; i > -1; i--) {
//                            cart.cartProducts.remove(i);
//                        }
//                        break;
//                    case PRINT_COMMAND:
//                        System.out.println(cart.toString());
//                        break;
//                    case ADD_TO_CART_COMMAND:
//                        gotId = Integer.parseInt(bufferedReader.readLine());
//                        if (gotId > 4 || gotId < 0) {
//                            System.out.println("Not valid ID.");
//                            break;
//                        }
//                        cart.addProductToCart(gotId);
//                        System.out.println("Product with ID " + gotId + " added to cart!");
//                        break;
//                    case ADD_ALL_TO_CART_COMMAND:
//                        cart.addAllProductsToCart();
//                        System.out.println("All products was added to cart!");
//                        break;
//                    case REMOVE_FROM_CART_COMMAND:
//                        gotId = Integer.parseInt(bufferedReader.readLine());
//                        if (gotId > 4 || gotId < 0) {
//                            System.out.println("Not valid ID.");
//                            break;
//                        }
//                        cart.deleteProductFromCart(gotId);
//                        System.out.println("Products with ID " + gotId + " removed from cart!");
//                        break;
//                    case REMOVE_FROM_COUNT_COMMAND:
//                        System.out.println("Products in cart:" + cart.cartProducts.size());
//                        break;
//                    case STOP_COMMAND:
//                        break;
//                    default:
//                        System.out.println("NOT VALID COMMAND");
//                        break;
//                }
//            }
//            System.out.println("OUT OF WHILE, BUT SERVER STILL ALIVE!");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
