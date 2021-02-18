package ru.geekbrains.VaolEr.service;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.VaolEr.dto.CartTo;
import ru.geekbrains.VaolEr.model.Cart;
import ru.geekbrains.VaolEr.repository.CartsRepository;

import java.util.List;
import java.util.UUID;

import static ru.geekbrains.VaolEr.util.CartsUtil.fromCartTo;

@Service
@RequiredArgsConstructor
public class CartsRestService {

    private final CartsRepository cartsRepository;

    public List<Cart> getByBuyerId(Long buyerId) throws NotFoundException {
        //тут по-хорошему нужно ещё сделать проверку на наличие данных в базе
        String exceptionMessage = "Not found entity with city: " + buyerId;
        if(cartsRepository.findCartsByBuyer_Id(buyerId).isEmpty()) throw new NotFoundException(exceptionMessage);
        else{
            return cartsRepository.findCartsByBuyer_Id(buyerId);
        }
    }

    public Cart create(CartTo cartTo) {
        Cart newCart = fromCartTo(cartTo);
        return cartsRepository.save(newCart);
    }

    @Transactional
    public void delete(Integer id) {
        cartsRepository.deleteById(id);
    }
}
