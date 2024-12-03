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

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "Tanc{" +
                "id=" + id +
                ", datum=" + datum +
                ", nev='" + nev + '\'' +
                '}';
    }
}