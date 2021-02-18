package ru.geekbrains.VaolEr.web;

import io.swagger.v3.oas.annotations.Operation;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.geekbrains.VaolEr.dto.CartTo;
import ru.geekbrains.VaolEr.dto.CustomerTo;
import ru.geekbrains.VaolEr.dto.RestResponseTo;
import ru.geekbrains.VaolEr.model.Cart;
import ru.geekbrains.VaolEr.model.Customer;
import ru.geekbrains.VaolEr.service.CartsRestService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static ru.geekbrains.VaolEr.util.CartsUtil.toCartTo;
import static ru.geekbrains.VaolEr.util.CartsUtil.toCartTos;
import static ru.geekbrains.VaolEr.util.CustomersUtil.toCustomerTo;

@RestController
@RequestMapping(value = "${app.endpoints.base_path}" + "${app.endpoints.carts-rest.base_url}",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CartsRestController {

    private final CartsRestService cartsRestService;

    @GetMapping("/{buyerId}")
    @Operation(summary = "Get list of all customers or list of customers where customer first name contains [firstName]")
    public RestResponseTo<List<CartTo>> getAllCartsByBuyerId(@PathVariable Long buyerId) throws NotFoundException {
        return new RestResponseTo<>(
                HttpStatus.OK.toString(), null, toCartTos(cartsRestService.getByBuyerId(buyerId))
        );
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create new cart")
    public ResponseEntity<?> create(@Valid @RequestBody CartTo cartTo) {
        Cart created = cartsRestService.create(cartTo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(
                new RestResponseTo<>(HttpStatus.CREATED.toString(), null, toCartTo(created))
        );
    }

}
