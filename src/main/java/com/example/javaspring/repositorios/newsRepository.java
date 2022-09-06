package com.example.javaspring.repositorios;

import com.example.javaspring.models.news;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface newsRepository extends CrudRepository<news, Long> {
    public List<news> findByTitle(String title);
    public List<news> findByTitleContains(String title);
}
