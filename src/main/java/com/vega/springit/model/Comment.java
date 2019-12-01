package com.vega.springit.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


// !!!!@Entity geeft aan dat deze class een entity class is, belangrijk voor database, creert een tabel met de classnaam
@Entity
// @NoArgsConstructor en @Data komen van Lombok. Maakt opzet makkelijker, hoeft net zelf getters, setters, noString etc aan te maken
@NoArgsConstructor
@Data
public class Comment extends Auditable {

    // !!!!!@Id specificeert de primary key van de tabel!!!
    @Id
   // The @GeneratedValue annotation is to configure the way of increment of the specified column(field).
    @GeneratedValue
    private Long id;
    @NonNull
    private String body;

    // Link
    @ManyToOne
    @NonNull
    private Link link;

    public Comment(String body, Link link) {
        this.body = body;
        this.link = link;
    }
}
