package com.biblioteca.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="edition_book")
public class EditionBook {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_edition")
    private Integer id;

    @Column(name = "date_edition")
    private Integer date;

    @Column(name = "state_editorial")
    private Integer state;

    @Column(name = "reason_editorial")
    private Integer reason;

    @Column(name = "telephone_editorial")
    private Integer telephone;


    @JsonIgnore
    @OneToMany(mappedBy="edition", targetEntity = DateEdition.class)
    private List<DateEdition> dateEditions;

    @JsonIgnore
    @OneToMany(mappedBy="edition", targetEntity = Book.class)
    private List<Book> books;






    public EditionBook(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }


    public List<DateEdition> getDateEditions() {
        return dateEditions;
    }

    public void setDateEditions(List<DateEdition> dateEditions) {
        this.dateEditions = dateEditions;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public DateEdition addDateEdition(DateEdition dateEdition) {
        getDateEditions().add(dateEdition);
        dateEdition.setEdition(this);

        return dateEdition;
    }

    public DateEdition removeDateEditions(DateEdition dateEdition) {
        getDateEditions().remove(dateEdition);
        dateEdition.setEdition(null);
        return dateEdition;
    }

    public Book addBook(Book book) {
        getBooks().add(book);
        book.setEdition(this);

        return book;
    }

    public Book removeBook(Book book) {
        getBooks().remove(book);
        book.setEdition(null);
        return book;
    }
}
