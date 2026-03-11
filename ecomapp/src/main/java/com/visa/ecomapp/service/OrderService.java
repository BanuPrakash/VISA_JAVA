package com.visa.ecomapp.service;

import com.visa.ecomapp.dto.ProductDTO;
import com.visa.ecomapp.entity.Customer;
import com.visa.ecomapp.entity.Product;
import com.visa.ecomapp.repo.CustomerRepo;
import com.visa.ecomapp.repo.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;

//    @Autowired
//    private  CustomerRepo customerRepo;
//    @Autowired
//    private  ProductRepo productRepo;

//    public OrderService(CustomerRepo customerRepo, ProductRepo productRepo) {
//        this.customerRepo = customerRepo;
//        this.productRepo = productRepo;
//    }

    @Transactional
    public Product modifyProduct(int id, double price) {
        productRepo.updateProduct(id, price);
        return getProductById(id);
    }

    public List<ProductDTO> getScalar() {
        return productRepo.getProductData();
    }

    public List<Product> getProducts() {
        return  productRepo.findAll();
    }

    public Product addProduct(Product product) {
        return  productRepo.save(product);
    }

    public Product getProductById(int id) {
        Optional<Product> opt = productRepo.findById(id);
        if(opt.isPresent()) {
            return  opt.get();
        }
        return null;
    }

    public List<Customer> getCustomers() {
        return  customerRepo.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return  customerRepo.save(customer);
    }

    public long getCustomerCount() {
        return  customerRepo.count();
    }
}
