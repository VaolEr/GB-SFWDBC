package ru.geekbrains.VaolEr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.VaolEr.model.Customer;

import java.util.List;

@Transactional(readOnly = true)
public interface CustomersRepository extends JpaRepository<Customer, String> {


    List<Customer> findByFirstNameContaining(String firstName);

    List<Customer> findByLastNameContaining(String firstName);

    List<Customer> findByCity(String city);

    Customer getCustomerById(String id);

}
