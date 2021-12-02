package com.biblioteca.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="editorial")
public class Editorial {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_editorial")
    private Integer id;

    @Column(name="name_editorial")
    private String name;

    @Column(name="email_editorial")
    private String email;

    @Column(name="address_editorial")
    private String address;

    @Column(name = "telephone_editorial")
    private Integer telephone;

    @JsonIgnore
    @OneToMany(mappedBy="editorial", targetEntity = Book.class)
    private List<Book> books;

    public Editorial(){

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book addBook(Book book) {
        getBooks().add(book);
        book.setEditorial(this);

        return book;
    }

    public Book removeBook(Book book) {
        getBooks().remove(book);
        book.setEditorial(null);
        return book;
    }

}
