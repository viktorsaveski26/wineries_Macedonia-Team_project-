package com.example.dizajn.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Vina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float X;
    private Float Y;
    private String name;
    private String website;
    private String opening_hours;
    private String phone;
    private String email;
    private Float rating;

    public Vina(Float x, Float y, String name, String website, String opening_hours, String phone, String email) {
        X = x;
        Y = y;
        this.name = name;
        this.website = website;
        this.opening_hours = opening_hours;
        this.phone = phone;
        this.email = email;
    }

    public String getKoordinati() {
        return X + "," + Y;
    }
}
