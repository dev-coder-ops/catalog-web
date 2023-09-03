package com.gudfeat.org.catalogweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Item {
    @Id
    private long uid;
    private long id;
    private String name;
    private String description;
    private double price;
    private double weight;
    private String brand;
    private String category;
}
