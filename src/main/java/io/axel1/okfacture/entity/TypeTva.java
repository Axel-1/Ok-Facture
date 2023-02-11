package io.axel1.okfacture.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Type_TVA")
public class TypeTva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code_tva", nullable = false)
    private Integer id;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @JsonManagedReference
    @OneToMany(mappedBy = "typeTva", cascade = CascadeType.ALL)
    private List<Tva> tvas;
}