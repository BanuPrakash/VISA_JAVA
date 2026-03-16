package com.visa.ecomapp.api;

import com.visa.ecomapp.entity.Product;
import com.visa.ecomapp.service.EntityNotFoundException;
import com.visa.ecomapp.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final OrderService service;

    // GET http://localhost:8080/api/products
    //GET http://localhost:8080/api/products?low=10000&high=50000
    // Accept: application/json
    @GetMapping()
    public List<Product> getProducts(@RequestParam(value = "low", defaultValue = "0.0") double low,
                                     @RequestParam(value = "high", defaultValue = "0.0") double high) {
        if(low == 0.0 && high == 0.0) {
            return service.getProducts();
        } else {
            return  service.getProductsByRange(low, high);
        }
    }

    // GET http://localhost:8080/api/products/3
    // Accept: application/json
    @GetMapping("/{pid}")
    public  Product getProduct(@PathVariable("pid") int id) throws EntityNotFoundException  {
        return service.getProductById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED) // 201
    public Product addProduct(@RequestBody @Valid Product product) {
        return service.addProduct(product); // includes ID
    }

    //PATCH http://localhost:8080/api/products/4?price=53.25
    @PatchMapping("/{pid}")
    public Product updateProductPrice(@PathVariable("pid") int id,
                                     @RequestParam("price") double price) throws EntityNotFoundException {
       return service.modifyProduct(id, price);
//
//        return "Product modified!!!";
    }

    @PutMapping("/{pid}")
    public Product modifyProduct(@PathVariable("pid") int id,
                                 @RequestBody Product product) throws EntityNotFoundException {
        System.out.println("Trying to update " + product);
        // update service
        return service.modifyProduct(id, product.getPrice());
    }
}
