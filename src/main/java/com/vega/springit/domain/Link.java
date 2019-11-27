package com.vega.springit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

// !!!!@Entity geeft aan dat deze class een entity class is, belangrijk voor database, creert een tabel met de classnaam
@Entity
// @NoArgsConstructor en @Data komen van Lombok. Maakt opzet makkelijker, hoeft net zelf getters, setters, noString etc aan te maken
@NoArgsConstructor
@Data
public class Link {

    // !!!!!  @Id specificeert de primary key van de tabel!!!
    @Id
    //The @GeneratedValue annotation is to configure the way of increment of the specified column(field).
    @GeneratedValue
    private long id;
    @NonNull
    private String title;
    @NonNull
    private String url;

    //comments
    @OneToMany(mappedBy = "Link")
    private List<Comment> comments = new ArrayList<>();

}
