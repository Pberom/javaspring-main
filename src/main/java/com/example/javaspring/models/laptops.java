package com.example.javaspring.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class laptops {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String OC, GS, title, Dick;
    Double Display, Gabarits, Mass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOC() {
        return OC;
    }

    public void setOC(String OC) {
        this.OC = OC;
    }

    public String getGS() {
        return GS;
    }

    public void setGS(String GS) {
        this.GS = GS;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDick() {
        return Dick;
    }

    public void setDick(String dick) {
        Dick = dick;
    }

    public Double getDisplay() {
        return Display;
    }

    public void setDisplay(Double display) {
        Display = display;
    }

    public Double getGabarits() {
        return Gabarits;
    }

    public void setGabarits(Double gabarits) {
        Gabarits = gabarits;
    }

    public Double getMass() {
        return Mass;
    }

    public void setMass(Double mass) {
        Mass = mass;
    }

    public laptops(String OC, String GS, String title, String dick, Double display, Double gabarits, Double mass) {
        this.OC = OC;
        this.GS = GS;
        this.title = title;
        this.Dick = dick;
        this.Display = display;
        this.Gabarits = gabarits;
        this.Mass = mass;
    }

    public laptops() {
    }
}
