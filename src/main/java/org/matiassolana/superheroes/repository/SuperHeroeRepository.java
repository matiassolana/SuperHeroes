package org.matiassolana.superheroes.repository;

import java.util.List;

import org.matiassolana.superheroes.entity.SuperHeroe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroeRepository extends JpaRepository<SuperHeroe, Long> {
	List<SuperHeroe> findByNameContainingIgnoreCase(String name);
}
