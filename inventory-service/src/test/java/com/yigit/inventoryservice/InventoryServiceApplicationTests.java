package com.yigit.inventoryservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yigit.inventoryservice.model.Inventory;
import com.yigit.inventoryservice.repository.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class InventoryServiceApplicationTests {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Container
	static PostgreSQLContainer prSqlContainer = new PostgreSQLContainer("postgres:11.1")
			.withDatabaseName("test")
			.withPassword("test")
			.withUsername("test");

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		prSqlContainer.start();

		dynamicPropertyRegistry.add("spring.datasource.url",prSqlContainer::getJdbcUrl);
		dynamicPropertyRegistry.add("spring.datasource.username", prSqlContainer::getUsername);
		dynamicPropertyRegistry.add("spring.datasource.password", prSqlContainer::getPassword);
	}

	@Test
	void shouldRetrieveItems() throws Exception {
		//Sending request param list is a bit different from rest of them. I found a article issuing in detail -> https://reversecoding.net/spring-mvc-requestparam-binding-request-parameters/

		Inventory inventory = new Inventory();
		inventory.setQuantity(1);
		inventory.setSkuCode("test");
		inventoryRepository.save(inventory);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/inventory")
						.contentType(MediaType.APPLICATION_JSON)
						.param("skuCodes", "test"))
				.andExpect(status().isOk());


	}

}
