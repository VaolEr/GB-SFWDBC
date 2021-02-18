package ru.geekbrains.VaolEr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.VaolEr.model.Cart;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CartsRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findCartsByBuyer_Id(Long buyerId);

}
