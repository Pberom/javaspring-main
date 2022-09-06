package com.example.javaspring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class colors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String title, decription, darkness;
    Integer base;
    Double base_two;

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

    public colors(String title, String decription, String darkness, Integer base, Double base_two) {
        this.title = title;
        this.decription = decription;
        this.darkness = darkness;
        this.base = base;
        this.base_two = base_two;
    }

    public colors() {
    }
}
