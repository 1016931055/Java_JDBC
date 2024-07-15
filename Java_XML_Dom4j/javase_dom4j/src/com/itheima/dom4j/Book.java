package com.itheima.dom4j;

public class Book {
    private String id;
    private String name;
    private String author;
    private String sale;

    public Book() {
    }

    public Book(String id, String name, String author, String sale) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.sale = sale;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", sale='" + sale + '\'' +
                '}';
    }
}
