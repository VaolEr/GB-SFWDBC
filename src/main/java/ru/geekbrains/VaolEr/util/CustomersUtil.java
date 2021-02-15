package ru.geekbrains.VaolEr.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.geekbrains.VaolEr.dto.CustomerTo;
import ru.geekbrains.VaolEr.dto.ProductTo;
import ru.geekbrains.VaolEr.model.Customer;
import ru.geekbrains.VaolEr.model.Product;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomersUtil {

    //This class transforms model entity to JSON transferred entity
    // and to the other side

    public static CustomerTo toCustomerTo(Customer customer) {
        return CustomerTo
                .builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .city(customer.getCity())
                .build();
    }

    public static List<CustomerTo> toCustomerTos(List<Customer> customers) {
        return customers.stream().map(CustomersUtil::toCustomerTo).collect(Collectors.toList());
    }

    public static Customer fromCustomerTo(CustomerTo customerTo) {
        Customer newCustomer = new Customer();
        //newCustomer.setId(customerTo.getId());
        newCustomer.setFirstName(customerTo.getFirstName());
        newCustomer.setLastName(customerTo.getLastName());
        newCustomer.setCity(customerTo.getCity());
        return newCustomer;
    }

}
