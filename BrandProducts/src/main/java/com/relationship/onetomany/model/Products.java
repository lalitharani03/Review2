package com.relationship.onetomany.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Products {
    @Id
    private int productId;
    private String productName;
    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Brand brand;
}
