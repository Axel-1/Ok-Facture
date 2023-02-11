package io.axel1.okfacture.repository;

import io.axel1.okfacture.entity.Tva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvaRepository extends JpaRepository<Tva, Integer> {
}