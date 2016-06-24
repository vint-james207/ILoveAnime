package com.james.entities;

import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * Created by jamesyburr on 6/24/16.
 */
public class Anime {

    @Id
    @GeneratedValue
    Integer id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String comment;

    @Column(nullable = false)
    LocalDateTime time;

    int rating;

    @ManyToOne
    User user;

    public Anime() {
    }

    public Anime(String title, String comment, LocalDateTime time, int rating, User user) {
        this.title = title;
        this.comment = comment;
        this.time = time;
        this.user = user;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
