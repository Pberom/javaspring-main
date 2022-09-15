package com.example.javaspring.repositorios;

import com.example.javaspring.models.Filial;
import org.springframework.data.repository.CrudRepository;

public interface FilialResopitory extends CrudRepository<Filial, Long> {
    Filial findByName(String name);
}
