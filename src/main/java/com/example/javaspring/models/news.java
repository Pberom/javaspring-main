package com.example.javaspring.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class news {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше", min = 2, max = 1000)
    String title;
    @NotEmpty(message = "Поле не может быть пустым!")
    @Size(message = "Строка не может быть меньше", min = 2, max = 1000)
    String bodytext;
    @NotNull(message = "Авторство обязательно.")
    String avtor;
    @Min (message = "Число не может быть отрицательным", value = 0)
    @Max(message = "Число не может быть слишком большим!", value = 1000)
    @NotNull(message = "Поле не может быть пустым!")
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
