package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/store/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping(value = "/add",produces = MediaType.APPLICATION_JSON_VALUE )
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity addProduct(@RequestBody Product product) throws URISyntaxException{
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(product));
    }
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity deleteProduct(@PathVariable Long id) {

        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
