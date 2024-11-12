package org.example.Task5;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int year;
    private double price;

    public Book(String title, String author, String publisher, int year, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Publisher: " + publisher +
                ", Year: " + year + ", Price: " + price;
    }
}
