package org.matiassolana.superheroes.controller;

import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.matiassolana.superheroes.configuration.TimedApi;
import org.matiassolana.superheroes.entity.SuperHeroe;
import org.matiassolana.superheroes.service.SuperHeroeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SuperHeroeController {

	@Autowired
	private SuperHeroeService superHeroeService;

	@GetMapping("/saludar")
	public ResponseEntity<?> saludar() {
		return ResponseEntity.ok("Hola");
	}
	@TimedApi
	@GetMapping("/listar")
	public ResponseEntity<?> getAllSuperHeroe() {
		try {
			List<SuperHeroe> list = superHeroeService.getAllSuperHeroe();
			if (list.isEmpty() || list.size() == 0) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@TimedApi	
	@GetMapping("/{id}")
	public SuperHeroe getSuperHeroeById(@PathVariable long id) {
		return superHeroeService.getSuperHeroeById(id);
	}

	@TimedApi
	@GetMapping("/namecontains")
	public ResponseEntity<?> getAllSuperHeroeContainingString(@RequestParam String string) {
		try {
			List<SuperHeroe> list = superHeroeService.findByNameContaining(string);
			if (list.isEmpty() || list.size() == 0) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@TimedApi
	@PostMapping("/createsuperheroe")
	public SuperHeroe createSuperHeroe(@RequestBody SuperHeroe superheroe) {
		return superHeroeService.createSuperHeroe(superheroe);
	}

	@TimedApi
	@PutMapping("/modify/{id}")
	public ResponseEntity<SuperHeroe> updateSuperHeroe(@PathVariable Long id,
			@RequestBody SuperHeroe superHeroeDetails) {
		SuperHeroe updateSuperHeroe = superHeroeService.getSuperHeroeById(id);			

		updateSuperHeroe.setName(superHeroeDetails.getName());
		
		return ResponseEntity.ok(superHeroeService.updateSuperHeroe(updateSuperHeroe));
	}
	
	@TimedApi
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(NO_CONTENT)
	public void deleteSuperHeroe(@PathVariable Long id) {
		superHeroeService.deleteSuperHeroe(id);
		
	}

}
