package com.serverapp.metrodata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serverapp.metrodata.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByName(String name);
}
