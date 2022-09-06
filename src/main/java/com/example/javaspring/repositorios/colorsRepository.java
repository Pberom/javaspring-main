package com.example.javaspring.repositorios;

import com.example.javaspring.models.colors;
import com.example.javaspring.models.laptops;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface colorsRepository extends CrudRepository<colors, Long> {
    public List<colors> findByTitle(String title);

}
