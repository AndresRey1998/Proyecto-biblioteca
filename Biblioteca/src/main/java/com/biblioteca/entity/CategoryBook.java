package com.biblioteca.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category_book")
public class CategoryBook {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_category")
    private Integer id;

    @Column(name="name_category")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="category_book", targetEntity = Book.class)
    private List<Book> books;

    public CategoryBook(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public Book addBook(Book book) {
        getBooks().add(book);
        book.setCategory_book(this);

        return book;
    }

    public Book removeBook(Book book) {
        getBooks().remove(book);
        book.setCategory_book(null);
        return book;
    }
}
