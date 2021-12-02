package com.biblioteca.entity;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_book")
    private Integer id;

    @Column(name="title_book", unique=true)
    private String titleBook;

    @Column(name="date_publication")
    private String date;

    @Column(name="availability_book")
    private boolean availability;

    @Column(name="url_book")
    private String url;

    @Column(name="date_creation")
    private String dateC;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryBook category_book;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "id_edition")
    private EditionBook edition;

    public EditionBook getEdition() {
        return edition;
    }

    public void setEdition(EditionBook edition) {
        this.edition = edition;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public CategoryBook getCategory_book() {
        return category_book;
    }

    public void setCategory_book(CategoryBook category_book) {
        this.category_book = category_book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDateC() {
        return dateC;
    }

    public void setDateC(String dateC) {
        this.dateC = dateC;
    }
}
