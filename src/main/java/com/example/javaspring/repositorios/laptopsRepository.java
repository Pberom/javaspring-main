package com.example.javaspring.repositorios;

import com.example.javaspring.models.laptops;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface laptopsRepository extends CrudRepository<laptops, Long> {
    public List<laptops> findByTitle(String title);
    public List<laptops> findByTitleContains(String title);
}
