package com.yazici.productservice;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
/*
	@Container
	static PostgreSQLContainer prSqlContainer = new PostgreSQLContainer("postgres:11.1")
			.withDatabaseName("football_api_db")
			.withPassword("csd1993")
			.withUsername("postgres");

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.datasource.url",prSqlContainer::getJdbcUrl);
		dynamicPropertyRegistry.add("spring.datasource.username", prSqlContainer::getUsername);
		dynamicPropertyRegistry.add("spring.datasource.password", prSqlContainer::getPassword);
	}
	@Test
	void contextLoads() {
	}

	@Test
	void shouldCreateProduct() throws Exception {

		ProductRequest productRequest =  getProductRequest();
		String productRequestString =   objectMapper.writeValueAsString(productRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestString))
				.andExpect(status().isCreated());

	}

	private ProductRequest  getProductRequest() {
		return ProductRequest.builder()
				.name("Iphone 13")
				.description("Iphone 13")
				.price(BigDecimal.valueOf(1200))
				.build();
	}
*/
}
