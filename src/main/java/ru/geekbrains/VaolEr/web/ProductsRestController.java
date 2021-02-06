package ru.geekbrains.VaolEr.web;

import io.swagger.v3.oas.annotations.Operation;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.geekbrains.VaolEr.dto.ProductTo;
import ru.geekbrains.VaolEr.dto.RestResponseTo;
import ru.geekbrains.VaolEr.model.Product;
import ru.geekbrains.VaolEr.service.ProductRestService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static ru.geekbrains.VaolEr.util.ProductsUtil.toProductTo;
import static ru.geekbrains.VaolEr.util.ProductsUtil.toProductTos;

@RestController
@RequestMapping(value = "${app.endpoints.base_path}" + "${app.endpoints.products-rest.base_url}",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProductsRestController {

    private final ProductRestService productRestService;

    @GetMapping
    @Operation(summary = "Get list of all products or list of products where product name contains [name]")
    public RestResponseTo<List<ProductTo>> getAllOrByName(@RequestParam(required = false) String name) {
        return new RestResponseTo<>(
                HttpStatus.OK.toString(), null, toProductTos(productRestService.get(name))
        );
    }

    @GetMapping(path = "/moreThan/{minCost}")
    @Operation(summary = "Get list of all products or list of products where product name contains [name] and cost greater than [minCost]")
    public RestResponseTo<List<ProductTo>> getAllOrByNameWithMoreThanMinCost(@RequestParam(required = false) String name,
                                                          @PathVariable Double minCost) {
        return new RestResponseTo<>(
                HttpStatus.OK.toString(), null, toProductTos(productRestService.getWitMoreThanMinCost(name, minCost))
        );
    }

    @GetMapping(path = "/lessThan/{maxCost}")
    @Operation(summary = "Get list of all products or list of products where product name contains [name] and cost less than [maxCost]")
    public RestResponseTo<List<ProductTo>> getAllOrByNameWithLessThanMaxCost(@RequestParam(required = false) String name,
                                                          @PathVariable Double maxCost) {
        return new RestResponseTo<>(
                HttpStatus.OK.toString(), null, toProductTos(productRestService.getWitLessThanMaxCost(name, maxCost))
        );
    }

    @GetMapping(path = "/costBetween/{minCost}&{maxCost}")
    @Operation(summary = "Get list of all products or list of products where product name contains [name] and cost in range [minCost] & [maxCost]")
    public RestResponseTo<List<ProductTo>> getAllOrByNameWithLessThanMaxCost(@RequestParam(required = false) String name,
                                                                             @PathVariable Double minCost,
                                                                             @PathVariable Double maxCost) {
        return new RestResponseTo<>(
                HttpStatus.OK.toString(), null, toProductTos(productRestService.getWitCostBetweenMinAndMax(name, minCost, maxCost))
        );
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get a product by id")
    public RestResponseTo<ProductTo> getById(@PathVariable Long id) throws NotFoundException {
        return new RestResponseTo<>(
                HttpStatus.OK.toString(), null, toProductTo(productRestService.getById(id))
        );
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create new product")
    public ResponseEntity<?> create(@Valid @RequestBody ProductTo productTo) {
        Product created = productRestService.create(productTo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(
                new RestResponseTo<>(HttpStatus.CREATED.toString(), null, toProductTo(created))
        );
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Delete product by it's id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productRestService.delete(id);
    }
}
