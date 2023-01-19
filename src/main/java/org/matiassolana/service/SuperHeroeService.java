package org.matiassolana.service;

import java.util.List;
import org.matiassolana.entity.SuperHeroe;
import org.matiassolana.repository.SuperHeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperHeroeService {
	
	@Autowired
	private SuperHeroeRepository superHeroeRepository;
	
	public List<SuperHeroe> getAllEmployees() {
        return superHeroeRepository.findAll();
    }

    public SuperHeroe getEmployeeById(long id) {
        return superHeroeRepository.findById(id).orElse(null);
    }

    public SuperHeroe createEmployee(SuperHeroe superHeroe) {
        return superHeroeRepository.save(superHeroe);
    }

    public SuperHeroe updateEmployee(SuperHeroe superHeroe) {
        return superHeroeRepository.save(superHeroe);
    }

    public void deleteEmployee(long id) {
    	superHeroeRepository.deleteById(id);
    }
}
