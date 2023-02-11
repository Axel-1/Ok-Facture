package io.axel1.okfacture.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_prod", nullable = false)
    private Integer id;

    @Column(name = "designation", length = 50)
    private String designation;

    @Column(name = "tarif_ht")
    private Double tarifHt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "code_tva", nullable = false)
    private TypeTva typeTva;

}