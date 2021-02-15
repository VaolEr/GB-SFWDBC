package ru.geekbrains.VaolEr.service;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.VaolEr.dto.CustomerTo;
import ru.geekbrains.VaolEr.model.Customer;
import ru.geekbrains.VaolEr.repository.CustomersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.util.StringUtils.hasText;
import static ru.geekbrains.VaolEr.util.CustomersUtil.fromCustomerTo;

@Service
@RequiredArgsConstructor
public class CustomerRestService {

    private final CustomersRepository customersRepository;

    public List<Customer> get(String firstName){
        return hasText(firstName) ? customersRepository.findByFirstNameContaining(firstName)
                : customersRepository.findAll();
    }

    public List<Customer> getByCity(String city) throws NotFoundException {
        //тут по-хорошему нужно ещё сделать проверку на наличие данных в базе
        String exceptionMessage = "Not found entity with city: " + city;
        if(customersRepository.findByCity(city).isEmpty()) throw new NotFoundException(exceptionMessage);
        else{
            return customersRepository.findByCity(city);
        }
    }

    public Customer getById(String id) throws NotFoundException {
        //тут по-хорошему нужно ещё сделать проверку на наличие данных в базе
        return customersRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found entity with"));
    }

    public List<Customer> getById(List<String> ids) throws NotFoundException {
        //тут по-хорошему нужно ещё сделать проверку на наличие данных в базе
        List<Customer> customers = new ArrayList<>();

        for (String id:ids) {
            String errorMsg = "Not found entity with id: " + id;
            customers.add(customersRepository.findById(id).orElseThrow(() -> new NotFoundException(errorMsg)));
        }

        return customers;
    }

    public Customer create(CustomerTo customerTo) {
        Customer newCustomer = fromCustomerTo(customerTo);
        newCustomer.setId(UUID.randomUUID().toString());
        return customersRepository.save(newCustomer);
    }

    @Transactional
    public void delete(String id) {
        customersRepository.deleteById(id);
    }

}
