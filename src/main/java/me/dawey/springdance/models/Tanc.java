package me.dawey.springdance.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Table(name = "tanc")
public class Tanc {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "datum")
    private Date datum;

    @Column(name = "nev")
    private String nev;

    public void setId(Long id) {
        this.id = Math.toIntExact(id);
    }
    public Long getId() {
        return (long) id;
    }
    public Date getDatum() {
        return datum;
    }
    public void setDatum(Date datum) {
        this.datum = datum;
    }
    public String getNev() {
        return nev;
    }
    public void setNev(String nev) {
        this.nev = nev;
    }
}