package com.petstore.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PetStoreApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getAllPets() throws Exception {

		mvc.perform(get("/pet-store/pets")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void getSomePets() throws Exception {
		String param = "Kitten";

		MvcResult mvcResult = mvc.perform(get("/pet-store/pets/" + param)).andDo(print()).andExpect(status().isOk()).andReturn();

	}

	@Test
	public void tryUpdateNoAuthentication() throws Exception {

		mvc.perform(put("/pet-store/pet/someId")).andDo(print()).andExpect(status().isUnauthorized());

	}

	@Test
	public void tryToLogin() throws Exception {
		mvc.perform(post("/login").param("username", "user").param("password", "user")).andDo(print()).andExpect(status().isOk());

	}


}
