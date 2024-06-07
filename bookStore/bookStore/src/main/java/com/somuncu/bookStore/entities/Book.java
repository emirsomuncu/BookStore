package com.somuncu.bookStore.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id ;

    @Column(name = "name")
    @Size(min = 1,message = "Plase enter the book name")
    private String name ;

    @Column(name = "author")
    @Size(min = 1,message = "Plase enter the author name")
    private String author;

    @Column(name = "price")
    @NotNull(message = "Plase enter the price")
    private Double price ;

}
