package io.axel1.okfacture.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Parametre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom_entreprise", length = 50)
    private String nomEntreprise;

    @Column(name = "rue", length = 50)
    private String rue;

    @Column(name = "cp", length = 50)
    private String cp;

    @Column(name = "ville", length = 50)
    private String ville;

    @Column(name = "tel", length = 50)
    private String tel;

    @Column(name = "site_web", length = 50)
    private String siteWeb;

    @Column(name = "domiciliation", length = 50)
    private String domiciliation;

    @Column(name = "proprio_compte", length = 50)
    private String proprioCompte;

    @Column(name = "iban", length = 50)
    private String iban;

    @Column(name = "bic", length = 50)
    private String bic;

}