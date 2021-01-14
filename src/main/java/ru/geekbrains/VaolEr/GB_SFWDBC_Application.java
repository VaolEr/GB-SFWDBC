package ru.geekbrains.VaolEr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.geekbrains.VaolEr.repository.ProductRepository;

@SpringBootApplication
public class GB_SFWDBC_Application {

    static final String STOP_COMMAND = "STOP";
    static final String CLEAN_COMMAND = "CLEAN";
    static final String PRINT_COMMAND = "PRINT";
    static final String ADD_TO_CART_COMMAND = "ADD";
    static final String REMOVE_FROM_CART_COMMAND = "REMOVE";
    static final String REMOVE_FROM_COUNT_COMMAND = "COUNT";

    public static void main(String[] args) {
        SpringApplication.run(GB_SFWDBC_Application.class, args);

        Cart cart = new Cart(new ProductRepository());

        try (BufferedReader bufferedReader = new
            BufferedReader(new InputStreamReader(System.in))) {
            Thread
                .sleep(1000); //Для того, чтоб программа работала после полной инициализации спринга
            System.out.println("\nДобро пожаловать!\n"
                                   + "Для выхода из программы введите STOP.\n"
                                   + "Для добавления товаров в корзину введите команду ADD и затем id от 0 до 4.\n"
                                   + "Для удаления товаровов с конкретным ID из корзины введите команду REMOVE и затем id от 0 до 4.\n"
                                   + "Для очистки корзины введите CLEAN.\n"
                                   + "Для отображения содержимого корзины введите PRINT.\n"
                                   + "Для отображения количества элементов в корзине введите COUNT.");
            String command = "";
            while (!command.equals(STOP_COMMAND)) {
                command = bufferedReader.readLine().toUpperCase(Locale.ROOT);
                int gotId;
                switch (command) {
                    case CLEAN_COMMAND:
                        for (int i = 0; i < cart.cartProducts.size(); i++
                        ) {
                            cart.cartProducts.remove(i);
                        }
                        break;
                    case PRINT_COMMAND:
                        System.out.println(cart.toString());
                        break;
                    case ADD_TO_CART_COMMAND:
                        gotId = Integer.parseInt(bufferedReader.readLine());
                        if (gotId > 4 || gotId < 0) {
                            System.out.println("Not valid ID.");
                            break;
                        }
                        cart.addProductToCart(gotId);
                        System.out.println("Product with ID " + gotId + " added to cart!");
                        break;
                    case REMOVE_FROM_CART_COMMAND:
                        gotId = Integer.parseInt(bufferedReader.readLine());
                        if (gotId > 4 || gotId < 0) {
                            System.out.println("Not valid ID.");
                            break;
                        }
                        cart.deleteProductFromCart(gotId);
                        System.out.println("Products with ID " + gotId + " removed from cart!");
                        break;
                    case REMOVE_FROM_COUNT_COMMAND:
                        System.out.println("Products in cart:" + cart.cartProducts.size());
                        break;
                    case STOP_COMMAND:
                        break;
                    default:
                        System.out.println("NOT VALID COMMAND");
                        break;
                }
            }
            System.out.println("OUT OF WHILE, BUT SERVER STILL ALIVE!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
