package org.matiassolana.superheroes.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.matiassolana.superheroes.entity.SuperHeroe;
import org.matiassolana.superheroes.service.SuperHeroeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class SuperHeroeControllerTest {

	@MockBean
	private SuperHeroeService superHeroeService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetAllSuperHeroeContainingString() throws Exception {
		List<SuperHeroe> expected = new ArrayList<>();
		expected.add(new SuperHeroe(1L, "Iron Man"));
		expected.add(new SuperHeroe(2L, "Thor"));
		when(superHeroeService.findByNameContaining("Man")).thenReturn(expected);
		// Act
		MvcResult result = mockMvc.perform(get("/namecontains").param("string", "Man")).andExpect(status().isOk())
				.andReturn();
		// Assert
		List<SuperHeroe> actual = (List<SuperHeroe>) result.getResponse();
		assertEquals(actual, expected);
	}

	@Test
	public void testGetSuperHeroeById() throws Exception {
		SuperHeroe superHeroe = new SuperHeroe();
		superHeroe.setId(1L);
		superHeroe.setName("Iron Man");
		when(superHeroeService.getSuperHeroeById(1L)).thenReturn(superHeroe);

		mockMvc.perform(get("/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("Iron Man"));
		verify(superHeroeService).getSuperHeroeById(1L);
	}

}
