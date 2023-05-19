package com.example.ebook.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CATALOG")
public class CatalogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "IMAGE_URL") // Add a column for the image URL or path
    private String imageUrl;

    public CatalogEntity(int id, String name, String title, String author, String genre, int price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.author = author;
        this.price = price;
        this.imageUrl = imageUrl;
        this.genre = genre;
    }

    public CatalogEntity() {

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
