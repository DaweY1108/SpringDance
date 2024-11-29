package me.dawey.springdance.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;


import java.util.Date;

@Entity
@Table(name = "tag")
public class Tag {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nev")
    private String nev;

    @Column(name = "ferfi")
    private double ferfi;

    @Column(name = "szulido")
    private Date szulido;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getNev() {
        return nev;
    }
    public void setNev(String nev) {
        this.nev = nev;
    }
    public double getFerfi() {
        return ferfi;
    }
    public void setFerfi(double ferfi) {
        this.ferfi = ferfi;
    }

    public Date getSzulido() {
        return szulido;
    }
    public void setSzulido(Date szulido) {
        this.szulido = szulido;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", ferfi=" + ferfi +
                ", szulido=" + szulido +
                '}';
    }
}