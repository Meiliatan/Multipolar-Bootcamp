package com.multipolar.bootcamp.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")

public class productController {
    @GetMapping("/product")
    public ResponseEntity<List<Product>> product(){
        List<Product> todoList = List.of(
                new Product(1, "Susu"),
                new Product(2, "Air"),
                new Product(3, "Minyak")
        );
        return ResponseEntity.ok(todoList);
    }
}
