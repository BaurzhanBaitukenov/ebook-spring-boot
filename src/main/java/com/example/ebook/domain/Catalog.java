package com.example.ebook.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Catalog {

    private long id;

    private String name;

    private String title;

    private String author;

    private String genre;

    private int price;

    private String imageUrl;

    @JsonCreator
    public Catalog(@JsonProperty("id") final long id,
                   @JsonProperty("name") final String name,
                   @JsonProperty("title") final String title,
                   @JsonProperty("author") final String author,
                   @JsonProperty("genre") final String genre,
                   @JsonProperty("price") final int price,
                   @JsonProperty("imageUrl") final String imageUrl) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
