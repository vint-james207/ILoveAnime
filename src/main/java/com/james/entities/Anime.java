package com.james.entities;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by jamesyburr on 6/24/16.
 */

@Entity
@Table(name = "animes")
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

    @ManyToOne
    User user;

    public Anime( String title, String comment, LocalDateTime time) {
        this.title = title;
        this.comment = comment;
        this.time = time;
    }

    public Anime() {
    }

    public Anime(String title, String comment, LocalDateTime time, User user) {
        this.title = title;
        this.comment = comment;
        this.time = time;
        this.user = user;
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
}
