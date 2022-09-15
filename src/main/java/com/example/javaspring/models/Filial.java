package com.example.javaspring.models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(name="worker_filial",
            joinColumns=@JoinColumn(name="filial_id"),
            inverseJoinColumns=@JoinColumn(name="worker_id"))
    private List<Worker> Workers;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Worker> getWorkers() {
        return this.Workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.Workers = workers;
    }
}
