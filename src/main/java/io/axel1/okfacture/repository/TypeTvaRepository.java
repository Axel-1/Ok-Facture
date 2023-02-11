package io.axel1.okfacture.repository;

import io.axel1.okfacture.entity.TypeTva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTvaRepository extends JpaRepository<TypeTva, Integer> {
}