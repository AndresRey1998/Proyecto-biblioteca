package com.biblioteca.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="date_edition")
public class DateEdition {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_date")
    private Integer id;

    @Column(name = "date_edition")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "edition")
    private EditionBook edition;



    public DateEdition(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public EditionBook getEdition() {
        return edition;
    }

    public void setEdition(EditionBook edition) {
        this.edition = edition;
    }

}
