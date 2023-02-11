package io.axel1.okfacture.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "TVA")
public class Tva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tva", nullable = false)
    private Integer id;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Column(name = "valeur")
    private Double valeur;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "code_tva", nullable = false)
    private TypeTva typeTva;

}