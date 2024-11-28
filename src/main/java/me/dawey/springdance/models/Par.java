package me.dawey.springdance.models;


import jakarta.persistence.*;

@Entity
@Table(name = "par")
public class Par {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tancid")
    private int tancId;

    @Column(name = "ferfiid")
    private int ferfiId;

    @Column(name = "noid")
    private int noId;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTancId() {
        return tancId;
    }

    public void setTancId(int tancId) {
        this.tancId = tancId;
    }

    public int getFerfiId() {
        return ferfiId;
    }

    public void setFerfiId(int ferfiId) {
        this.ferfiId = ferfiId;
    }

    public int getNoId() {
        return noId;
    }

    public void setNoId(int noId) {
        this.noId = noId;
    }

    @Override
    public String toString() {
        return "Par{" +
                "id=" + id +
                ", tancId=" + tancId +
                ", ferfiId=" + ferfiId +
                ", noId=" + noId +
                '}';
    }
}