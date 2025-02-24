package com.example.LearningJPA.Controllers;


import com.example.LearningJPA.Entity.ProductEntity;
import com.example.LearningJPA.Repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductRepository productRepository;


    public  ProductController (ProductRepository productRepository){
        this.productRepository =productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy) {
//        return productRepository.findBy(Sort.by(sortBy));
        return productRepository.findBy(Sort.by(
                Sort.Order.desc(sortBy),
                Sort.Order.asc("title")
        ));
    }

}
