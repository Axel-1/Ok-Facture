package io.axel1.okfacture.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class LigneFactureId implements Serializable {
    private static final long serialVersionUID = 6463225050367820504L;
    @Column(name = "id_fac", nullable = false)
    private Integer idFac;

    @Column(name = "id_prod", nullable = false)
    private Integer idProd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LigneFactureId entity = (LigneFactureId) o;
        return Objects.equals(this.idProd, entity.idProd) &&
                Objects.equals(this.idFac, entity.idFac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProd, idFac);
    }

}