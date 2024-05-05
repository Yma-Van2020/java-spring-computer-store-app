package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.repositories.ProductRepository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 *
 *
 *
 *
 */
@Controller
public class BuyProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") long productId, Model theModel) {
        // Retrieve the product from the repository
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            int currentInventory = product.getInv();
            if (currentInventory > 0) {
                // Decrease the inventory by 1
                product.setInv(currentInventory - 1);
                productRepository.save(product);

                return "purchaseSuccess"; // Redirect to purchase success page
            } else {
                return "purchaseError"; // Redirect to purchase error page (out of stock)
            }
        } else {
            return "purchaseError"; // Redirect to purchase error page (product not found)
        }
    }
}