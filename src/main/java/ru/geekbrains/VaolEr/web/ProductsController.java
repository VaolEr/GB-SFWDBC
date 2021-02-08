package ru.geekbrains.VaolEr.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.VaolEr.dao.ProductDAO;
import ru.geekbrains.VaolEr.model.Product;
import ru.geekbrains.VaolEr.repository.ProductsRepository;
import ru.geekbrains.VaolEr.service.ProductRestService;
import ru.geekbrains.VaolEr.service.ProductsService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
@RequestMapping(value = "${app.endpoints.base_path}" + "${app.endpoints.products.base_url}",
    produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;
    private final ProductsRepository productsRepository;

    @GetMapping
    //@Operation(summary = "Get all products or list of items where product name contains [name]")
    public String allProductsPage(Model model){
        //model.addAttribute("products", productsService.getAllProducts());
        model.addAttribute("products", productsRepository.findAll());
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

    @PostMapping(value = "/delete")
    public String deleteProduct(@RequestParam String id) {
        Long productId = Long.parseLong(id);
        System.out.println(productId);
        productsRepository.deleteById(productId);
        return "redirect:/api/v1/products";
    }


    @GetMapping(value = "/listProducts")
    public String listProducts(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Product> productPage = productsService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("productPage", productPage);

        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "/listProducts";
    }

//    @GetMapping
//    @Operation(summary = "Get all products or list of items where product name contains [name]")
//    public String allProductsPage(Model model){
//        model.addAttribute("message", "Hello World");
//        model.addAttribute("test", "One more string");
//        return "/index";
//    }
}
