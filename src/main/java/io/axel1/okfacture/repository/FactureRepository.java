package io.axel1.okfacture.repository;

import io.axel1.okfacture.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {
}