package io.axel1.okfacture.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Ligne_Facture")
public class LigneFacture {
    @EmbeddedId
    private LigneFactureId id = new LigneFactureId();

    @JsonBackReference
    @MapsId("idFac")
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_fac", nullable = false)
    private Facture facture;

    @MapsId("idProd")
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_prod", nullable = false)
    private Produit produit;

    @Column(name = "qte")
    private Integer qte;

    @Column(name = "prix_facture_ht")
    private Double prixFactureHt;

    @Formula("(SELECT t.valeur " +
            "FROM tva t " +
            "JOIN facture f ON id_fac = f.id_fac " +
            "JOIN produit p ON id_prod = p.id_prod " +
            "WHERE t.date_debut < f.date_facturation AND t.date_fin > f.date_facturation AND t.code_tva = p.code_tva)")
    private Double valeurTva;

    @Formula("ROUND(prix_facture_ht * qte, 2)")
    private Double totalPrixFactureHt;
}