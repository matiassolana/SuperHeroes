package org.matiassolana.repository;

import org.matiassolana.entity.SuperHeroe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroeRepository extends JpaRepository<SuperHeroe, Long> {

}
