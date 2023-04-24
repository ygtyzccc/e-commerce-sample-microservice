package com.yigit.orderservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yigit.orderservice.dto.OrderLineItemsDto;
import com.yigit.orderservice.dto.OrderRequest;
import com.yigit.orderservice.repository.OrderRepository;
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

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class OrderServiceApplicationTests {

	@Autowired
	private OrderRepository orderRepository;

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
	void shouldCreateOrder() throws Exception {

		OrderRequest orderRequest =  getOrderRequest();
		String orderRequestString =   objectMapper.writeValueAsString(orderRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/order")
						.contentType(MediaType.APPLICATION_JSON)
						.content(orderRequestString))
				.andExpect(status().isCreated());


	}

	private OrderRequest  getOrderRequest() {
		OrderLineItemsDto line1 = OrderLineItemsDto.builder()
				.id(1L)
				.quantity(2)
				.price(BigDecimal.TEN)
				.skuCode("Test")
				.build();

		List<OrderLineItemsDto> orderList = Arrays.asList(line1);

		return OrderRequest.builder()
				.orderLineItemsDtos(orderList)
				.build();


	}


}
