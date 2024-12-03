package me.dawey.springdance.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "A felhasználónév megadása kötelező")
    @Size(min = 3, max = 50, message = "A felhasználónévnek 3 és 50 karakter között kell lennie")
    @Column(unique = true)
    private String name;

    @NotBlank(message = "Az email cím megadása kötelező")
    @Email(message = "Az email cím nem megfelelő")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "A jelszó megadása kötelező")
    @Size(min = 6, message = "A jelszónak legalább 6 karakter hosszúnak kell lennie")
    private String password;

    @Column(nullable = false)
    private String role = "User";

    // Getters and Setters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}