package com.soumya.mircroservies.product;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {


	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest")
			.withExposedPorts(27017);

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mongoDBContainer.start();
	}
	@Test
	void shouldCreateProduct() {
		String requestBody = """
				{
				    "name":"Iphone 15",
				    "description":"A smart phone from Apple",
				    "price": 1000
				}
				""";
		RestAssured.given().contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/products")
				.then()
				.statusCode(201)
				.body("id", org.hamcrest.Matchers.notNullValue())
				.body("name", org.hamcrest.Matchers.equalTo("Iphone 15"))
				.body("description", org.hamcrest.Matchers.equalTo("A smart phone from Apple"))
				.body("price", org.hamcrest.Matchers.isOneOf(1000, 1000.0, 1000.0f));
	}

}
