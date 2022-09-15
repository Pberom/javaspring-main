package com.example.javaspring.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
public class colors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше", min = 2, max = 1000)
    String title;
    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше", min = 2, max = 1000)
    String decription;
    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше", min = 2, max = 1000)
    String darkness;

    @Min(message = "Число не может быть отрицательным", value = 0)
    @Max(message = "Число не может быть слишком большим!", value = 1000)
    @NotNull(message = "Поле не может быть пустым!")
    Integer base;
    @Min(message = "Число не может быть отрицательным", value = 0)
    @Max(message = "Число не может быть слишком большим!", value = 1000)
    @NotNull(message = "Поле не может быть пустым!")
    Double base_two;
    @OneToMany (mappedBy = "name", fetch = FetchType.EAGER)
    Collection<Worker> workers;

    public Collection<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Collection<Worker> students) {
        this.workers = students;
    }

    public laptops getLaptops(laptops laptops) {
        return laptops;
    }

    public void setLaptops(laptops laptops) {
        this.laptops = laptops;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public laptops laptops;

    public colors(String title, String decription, String darkness, Integer base, Double base_two, laptops laptops, Collection<Worker> workers) {
        this.title = title;
        this.decription = decription;
        this.darkness = darkness;
        this.base = base;
        this.base_two = base_two;
        this.laptops = laptops;
        this.workers = workers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getDarkness() {
        return darkness;
    }

    public void setDarkness(String darkness) {
        this.darkness = darkness;
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Double getBase_two() {
        return base_two;
    }

    public void setBase_two(Double base_two) {
        this.base_two = base_two;
    }

    public colors() {
    }
}
