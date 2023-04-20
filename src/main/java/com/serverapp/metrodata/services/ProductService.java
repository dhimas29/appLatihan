package com.serverapp.metrodata.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.serverapp.metrodata.models.Product;
import com.serverapp.metrodata.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));
    }

    public Product create(Product product) {
        if (!productRepository.findByName(product.getName()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "name product already exist!!!");
        }
        // Product tempProduct = modelMapper.map(product, Product.class);
        return productRepository.save(product);
    }

    public Product update(Integer id, Product product) {
        getById(id);
        product.setId(id);
        Product tempProduct = modelMapper.map(product, Product.class);
        return productRepository.save(tempProduct);
    }

    public Product delete(Integer id) {
        Product product = getById(id);
        productRepository.delete(product);
        return product;
    }
}
