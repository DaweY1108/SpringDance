package me.dawey.springdance.models;


import jakarta.persistence.*;
import jakarta.validation.Constraint;

@Entity
@Table(name = "par")
public class Par {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "tancid", nullable = false)
    private Tanc tanc;

    @ManyToOne
    @JoinColumn(name = "ferfiid", nullable = false)
    private Tag ferfi;

    @ManyToOne
    @JoinColumn(name = "noid", nullable = false)
    private Tag no;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tanc getTanc() {
        return tanc;
    }

    public void setTanc(Tanc tanc) {
        this.tanc = tanc;
    }

    public Tag getFerfi() {
        return ferfi;
    }

    public void setFerfi(Tag ferfi) {
        this.ferfi = ferfi;
    }

    public Tag getNo() {
        return no;
    }

    public void setNo(Tag no) {
        this.no = no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Par)) return false;

        Par par = (Par) o;

        if (getId() != par.getId()) return false;
        if (!getTanc().equals(par.getTanc())) return false;
        if (!getFerfi().equals(par.getFerfi())) return false;
        return getNo().equals(par.getNo());
    }

    @Override
    public String toString() {
        return "Par{" +
                "id=" + id +
                ", tanc=" + getTanc().toString() +
                ", ferfi=" + getFerfi().toString() +
                ", no=" + getNo().toString() +
                '}';
    }
}