package com.visa.ecomapp.service;

import com.visa.ecomapp.dto.ProductDTO;
import com.visa.ecomapp.entity.Customer;
import com.visa.ecomapp.entity.LineItem;
import com.visa.ecomapp.entity.Order;
import com.visa.ecomapp.entity.Product;
import com.visa.ecomapp.repo.CustomerRepo;
import com.visa.ecomapp.repo.OrderRepo;
import com.visa.ecomapp.repo.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

//    @Autowired
//    private  CustomerRepo customerRepo;
//    @Autowired
//    private  ProductRepo productRepo;

//    public OrderService(CustomerRepo customerRepo, ProductRepo productRepo) {
//        this.customerRepo = customerRepo;
//        this.productRepo = productRepo;
//    }

    /*
        {
            customer: {
                "email": "reena@visa.com"
            },
            "items": [
                {"product": {id: 3}, qty: 2},
                {"product": {id: 2}, qty: 1}
            ]
        }
     */
    @Transactional
    public String placeOrder(Order order) {
        double total = 0.0;

        List<LineItem> items = order.getItems();
        for(LineItem item : items) {
            Product product = productRepo.findById(item.getProduct().getId()).get();
            if(product.getQty()  < item.getQty()) {
                throw  new IllegalArgumentException("Product " + product.getName() + " not is Stock!!!");
            }
            item.setAmount(product.getPrice() * item.getQty());// TAX , DISCOUNT
            total += item.getAmount();
            product.setQty(product.getQty() - item.getQty()); //DIRTY CHECKING
        }
        order.setTotal(total);
//        order.setOrderDate(new Date());
        orderRepo.save(order); // save order and line items

        return  "Order Placed!!";
    }

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
