package io.axel1.okfacture.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code_client", nullable = false)
    private Integer id;

    @Column(name = "entreprise", length = 50)
    private String entreprise;

    @Column(name = "rue", length = 50)
    private String rue;

    @Column(name = "cp", length = 50)
    private String cp;

    @Column(name = "ville", length = 50)
    private String ville;

}