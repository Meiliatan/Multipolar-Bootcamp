package com.multipolar.bootcamp.product.service;

import com.multipolar.bootcamp.product.domain.Product;
import com.multipolar.bootcamp.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    //Fungsi Get AllCust == kembalian berupa List
    public List<Product> getAllProduct(){return productRepository.findAll();
    }

    //Fungsi Get cust by id
    public Optional<Product> getProductById(String id){
        return productRepository.findById(id);
    }

    //Fungsi Create cust baru
    public Product creatOrUpdateProduct(Product product){
        return productRepository.save(product);
    }

    //Fungsi Delete cust
    public void deleteProductById(String id){
        productRepository.deleteById(id);
    }

    //find Cust by nik
    // public Optional<Product> getCustomerById(String id){
    //    return productRepository.findById(id);
    //}

    //findByFirstName
//    public List<Product> getProductByName(String productName){
//        return productRepository.findByProductNameInsensitive(productName);
//    }
}
