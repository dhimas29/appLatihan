package com.serverapp.metrodata.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.serverapp.metrodata.models.Category;
import com.serverapp.metrodata.repositories.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "id not found"));
    }

    public Category create(Category category) {
        if (!categoryRepository.findByName(category.getName()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "name already exist!!");
        }
        return categoryRepository.save(category);
    }

    public Category update(Integer id, Category category) {
        getById(id);
        category.setId(id);
        return categoryRepository.save(category);
    }

    public Category delete(Integer id) {
        Category category = getById(id);
        categoryRepository.delete(category);
        return category;
    }
}
