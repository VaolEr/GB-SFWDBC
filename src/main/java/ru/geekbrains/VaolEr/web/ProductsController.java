package ru.geekbrains.VaolEr.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.VaolEr.model.Product;
import ru.geekbrains.VaolEr.repository.ProductsRepository;
import ru.geekbrains.VaolEr.service.ProductsService;


@Controller
@RequestMapping(value = "${app.endpoints.base_path}" + "${app.endpoints.products.base_url}",
    produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping
    //@Operation(summary = "Get all products or list of items where product name contains [name]")
    public String allProductsPage(Model model){
        model.addAttribute("products", productsService.getAllProducts());
        return "/products";
    }

    @GetMapping("/{id}")
    //@Operation(summary = "Get all products or list of items where product name contains [name]")
    public String productByIdPage(@PathVariable Integer id, Model model){
        model.addAttribute("product", productsService.getProductById(id));
        return "/product";
    }

    @GetMapping("/new")
    //@Operation(summary = "Get all products or list of items where product name contains [name]")
    public String addNewProduct(Model model){
        model.addAttribute("product", new Product());
        return "/newProduct";
    }

    @PostMapping()
    public String addProductToList(@ModelAttribute("product")Product product){
        productsService.save(product);
        return "redirect:/api/v1/products";
    }

//    @GetMapping
//    @Operation(summary = "Get all products or list of items where product name contains [name]")
//    public String allProductsPage(Model model){
//        model.addAttribute("message", "Hello World");
//        model.addAttribute("test", "One more string");
//        return "/index";
//    }
}
