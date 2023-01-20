package org.matiassolana.superheroes.service;

import java.util.List;

import org.matiassolana.superheroes.entity.SuperHeroe;
import org.matiassolana.superheroes.repository.SuperHeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SuperHeroeServiceImpl implements SuperHeroeService{
	
	@Autowired
	private SuperHeroeRepository superHeroeRepository;
	
	@Override
	@Cacheable("SuperHeroe")
	public List<SuperHeroe> getAllSuperHeroe() {
        return superHeroeRepository.findAll();
    }
	@Override
    public SuperHeroe getSuperHeroeById(long id) {
        return superHeroeRepository.findById(id).orElse(null);
    }

	@Override
	public List<SuperHeroe> findByNameContaining(String string) {
		return superHeroeRepository.findByNameContainingIgnoreCase(string);
	}

	
	@Override
    public SuperHeroe createSuperHeroe(SuperHeroe superHeroe) {
        return superHeroeRepository.save(superHeroe);
    }

	@Override
    public SuperHeroe updateSuperHeroe(SuperHeroe superHeroe) {
        return superHeroeRepository.save(superHeroe);
    }

	@Override
    public void deleteSuperHeroe(long id) {
    	superHeroeRepository.deleteById(id);
    }

}
