package com.udacity.pricing;

import com.udacity.pricing.repository.CarRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	CarRepository carRepo;

	@Test
	public void contextLoads() throws Exception {
		assertThat(mvc, notNullValue());
	}

	@Test
	public void carsIsOkay() throws Exception {
		mvc.perform(get("/cars")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void getAllCars() throws Exception {
		MvcResult result = mvc.perform(get("/cars")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		JSONObject resultObj = new JSONObject(result.getResponse().getContentAsString());
		JSONArray listOfCars = ((JSONObject) resultObj.get("_embedded")).getJSONArray("cars");
		assertThat(listOfCars.length(), is(20));
		for (int i = 0; i < 20; i++) {
			JSONObject car = listOfCars.getJSONObject(i);
			assertTrue(car.has("vehicleid"));
			assertTrue(car.has("price"));
			int vid = car.getInt("vehicleid");
			if (car.getInt("vehicleid") == 1) {
				Double price = car.getDouble("price");
				assertTrue(price.equals(30837.87));
			}
		}
	}

	@Test
	public void getCar7() throws Exception {
		MvcResult result = mvc.perform(get("/cars/7")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		JSONObject resultObj = new JSONObject(result.getResponse().getContentAsString());
		assertTrue(resultObj.has("price"));
		Double price = resultObj.getDouble("price");
		assertTrue(price.equals(17585.68));
	}
}
