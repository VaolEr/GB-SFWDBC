package ru.geekbrains.VaolEr.web;

import io.swagger.v3.oas.annotations.Operation;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.geekbrains.VaolEr.dto.CustomerTo;
import ru.geekbrains.VaolEr.dto.RestResponseTo;
import ru.geekbrains.VaolEr.model.Customer;
import ru.geekbrains.VaolEr.service.CustomerRestService;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static ru.geekbrains.VaolEr.util.CustomersUtil.toCustomerTo;
import static ru.geekbrains.VaolEr.util.CustomersUtil.toCustomerTos;

@RestController
@RequestMapping(value = "${app.endpoints.base_path}" + "${app.endpoints.customers-rest.base_url}",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CustomersRestController {
    private final CustomerRestService customerRestService;

    @GetMapping
    @Operation(summary = "Get list of all customers or list of customers where customer first name contains [firstName]")
    public RestResponseTo<List<CustomerTo>> getAllOrByFirstName(@RequestParam(required = false) String firstName) {
        return new RestResponseTo<>(
                HttpStatus.OK.toString(), null, toCustomerTos(customerRestService.get(firstName))
        );
    }

    @GetMapping(path = "/city/{city}")
    @Operation(summary = "Get list of customers where customer city contains [city]")
    public RestResponseTo<List<CustomerTo>> getAllByCity(@PathVariable String city) throws NotFoundException  {
        return new RestResponseTo<>(
                HttpStatus.OK.toString(), null, toCustomerTos(customerRestService.getByCity(city))
        );
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get a customer by id")
    public RestResponseTo<CustomerTo> getById(@PathVariable String id) throws NotFoundException {
        return new RestResponseTo<>(
                HttpStatus.OK.toString(), null, toCustomerTo(customerRestService.getById(id))
        );
    }

    @GetMapping(path = "/multiple/{customerIds}")
    @Operation(summary = "Get a customer by id")
    public RestResponseTo<List<CustomerTo>> getByIds(@PathVariable String customerIds) throws NotFoundException {
        List<String> ids = Arrays.asList(customerIds.split(","));
        return new RestResponseTo<>(
                HttpStatus.OK.toString(), null, toCustomerTos(customerRestService.getById(ids))
        );
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create new product")
    public ResponseEntity<?> create(@Valid @RequestBody CustomerTo customerTo) {
        Customer created = customerRestService.create(customerTo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(
                new RestResponseTo<>(HttpStatus.CREATED.toString(), null, toCustomerTo(created))
        );
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Delete product by it's id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        customerRestService.delete(id);
    }
}
