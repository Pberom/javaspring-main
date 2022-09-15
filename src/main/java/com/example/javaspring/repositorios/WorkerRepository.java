package com.example.javaspring.repositorios;

import com.example.javaspring.models.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker, Long> {
    Worker findByName(String name);
}
