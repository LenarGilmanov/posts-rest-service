package com.lenar.entity;

import com.lenar.dto.PostDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "author", nullable = false, length = 30)
    private String author;

    @Column(name = "creation_time", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "number_of_likes", nullable = false)
    private int numberOfLikes;

    @Column(name = "number_of_dislikes", nullable = false)
    private int numberOfDislikes;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    public Post() {}

    public Post(int id, String author, LocalDateTime creationDate, int numberOfLikes, int numberOfDislikes, String title) {
        this.id = id;
        this.author = author;
        this.creationDate = creationDate;
        this.numberOfLikes = numberOfLikes;
        this.numberOfDislikes = numberOfDislikes;
        this.title = title;
    }

    public Post(String author, LocalDateTime creationDate, int numberOfLikes, int numberOfDislikes, String title) {
        this.author = author;
        this.creationDate = creationDate;
        this.numberOfLikes = numberOfLikes;
        this.numberOfDislikes = numberOfDislikes;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationTime) {
        this.creationDate = creationTime;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public int getNumberOfDislikes() {
        return numberOfDislikes;
    }

    public void setNumberOfDislikes(int numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostDto toDto() {
        return new PostDto(
                getId(),
                getAuthor(),
                getCreationDate().toLocalDate(),
                getNumberOfLikes(),
                getNumberOfDislikes(),
                getTitle()
        );
    }
}
