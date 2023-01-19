package org.matiassolana.controller;

import java.util.List;
import java.util.Optional;

import org.matiassolana.entity.SuperHeroe;
import org.matiassolana.repository.SuperHeroeRepository;
import org.matiassolana.service.SuperHeroeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/superheroes")
public class SuperHeroeController {

	@Autowired
	private SuperHeroeService superHeroeService;

	@Autowired
	private SuperHeroeRepository superHeroeRepository;

	@GetMapping
	public ResponseEntity<List<SuperHeroe>> getAllEmployees() {
		try {
			List<SuperHeroe> list = superHeroeRepository.findAll();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	

	@GetMapping("/{id}")
	public SuperHeroe getEmployeeById(@PathVariable long id) {
		return superHeroeService.getEmployeeById(id);
	}

	@PostMapping
	public SuperHeroe createEmployee(@RequestBody SuperHeroe employee) {
		return superHeroeService.createEmployee(employee);
	}

	/*@PutMapping("/{id}")
	public ResponseEntity<SuperHeroe> updateSuperHeroe(@PathVariable Long id, @RequestBody SuperHeroe superHeroeDetails) {
		SuperHeroe updateSuperHeroe = superHeroeService.getEmployeeById(id)
				.orElseThrow(() -> new ResourceNotFoundException("SuperHeroe no encontrado id: " + id));

		superHeroe.setName(superHeroeDetails.getName());

		return superHeroeService.updateEmployee(superHeroe);
	}*/
}
