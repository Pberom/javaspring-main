package com.example.javaspring.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class news {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String title, bodytext, avtor;
    Integer views, likes;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBodytext() {
        return bodytext;
    }

    public String getAvtor() {
        return avtor;
    }

    public Integer getViews() {
        return views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBodytext(String bodytext) {
        this.bodytext = bodytext;
    }

    public void setAvtor(String avtor) {
        this.avtor = avtor;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public news(String title, String bodytext, String avtor, Integer views, Integer likes) {
        this.title = title;
        this.bodytext = bodytext;
        this.avtor = avtor;
        this.views = views;
        this.likes = likes;
    }

    public news() {
    }
}
