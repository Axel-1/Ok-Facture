package io.axel1.okfacture.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fac", nullable = false)
    private Integer id;

    @Column(name = "date_facturation")
    private LocalDate dateFacturation;

    @Column(name = "date_echeance")
    private LocalDate dateEcheance;

    @Column(name = "conditions_reg", length = 50)
    private String conditionsReg;

    @ManyToOne(optional = false)
    @JoinColumn(name = "code_client", nullable = false)
    private Client client;

    @JsonManagedReference
    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
    private List<LigneFacture> lignesFacture;

    @Formula("(SELECT ROUND(SUM(lf.qte * lf.prix_facture_ht), 2) " +
            "FROM ligne_facture lf " +
            "WHERE lf.id_fac = id_fac)")
    private Double totalHt;

    @Formula("(SELECT ROUND(SUM(lf.qte * lf.prix_facture_ht * t.valeur), 2) " +
            "FROM ligne_facture lf " +
            "JOIN produit p ON lf.id_prod = p.id_prod " +
            "JOIN tva t ON p.code_tva = t.code_tva " +
            "WHERE lf.id_fac = id_fac AND t.date_debut < date_facturation AND t.date_fin > date_facturation)")
    private Double totalTtc;
}