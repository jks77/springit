package com.vega.springit.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

// !!!!@Entity geeft aan dat deze class een entity class is, belangrijk voor database, creert een tabel met de classnaam
@Entity
@RequiredArgsConstructor
@Getter @Setter
@ToString
// @NoArgsConstructor en @Data komen van Lombok. Maakt opzet makkelijker, hoeft niet zelf getters, setters, noString etc aan te maken
@NoArgsConstructor

public class Link extends Auditable {

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
    // mappedBy zorgt voor 'Link_Id' in tabel, dit houdt dus in dat de comment gekoppeld wordt aan de Link ID (Foreign Key)
    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {comments.add(comment);
    }
}
