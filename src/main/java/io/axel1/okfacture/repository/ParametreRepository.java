package io.axel1.okfacture.repository;

import io.axel1.okfacture.entity.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Integer> {
}