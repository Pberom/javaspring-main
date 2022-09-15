package com.example.javaspring.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    colors colors;
    public com.example.javaspring.models.colors getColors() {
        return colors;
    }

    public void setColors(com.example.javaspring.models.colors color) {
        this.colors = colors;
    }

    public void setFilials(List<Filial> filials) {
        this.filials = filials;
    }


    @ManyToMany
    @JoinTable (name="worker_filial",
            joinColumns=@JoinColumn (name="worker_id"),
            inverseJoinColumns=@JoinColumn(name="filial_id"))
    private List<Filial> filials;


    public Worker() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Filial> getFilials() {
        return filials;
    }


    public Worker(colors colors, String name, List<Filial> filials)
    {
        this.name = name;
        this.colors = colors;
        this.filials = filials;
    }
}
