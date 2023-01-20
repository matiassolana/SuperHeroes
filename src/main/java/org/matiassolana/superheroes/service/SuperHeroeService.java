
package org.matiassolana.superheroes.service;

import java.util.List;

import org.matiassolana.superheroes.entity.SuperHeroe;

public interface SuperHeroeService {
	
	List<SuperHeroe> getAllSuperHeroe();

	SuperHeroe getSuperHeroeById(long id);

	List<SuperHeroe> findByNameContaining(String string);
	
	SuperHeroe createSuperHeroe(SuperHeroe superHeroe);

	SuperHeroe updateSuperHeroe(SuperHeroe superHeroe);

	void deleteSuperHeroe(long id);
}
