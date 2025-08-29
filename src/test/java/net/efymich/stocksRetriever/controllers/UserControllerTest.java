package net.efymich.stocksRetriever.controllers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import net.efymich.stocksRetriever.client.PolygonApiClient;
import net.efymich.stocksRetriever.dto.LoginDTO;
import net.efymich.stocksRetriever.dto.RegisterDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@MockitoBean(types = {PolygonApiClient.class})
public class UserControllerTest {

    @LocalServerPort
    private int port;

    private final RequestLoggingFilter requestLoggingFilter = new RequestLoggingFilter();
    private final ResponseLoggingFilter responseLoggingFilter = new ResponseLoggingFilter();

    @BeforeAll
    void setUp() {
        RestAssured.baseURI = "http://localhost/api/v1/users";
        RestAssured.port = port;
        RestAssured.filters(requestLoggingFilter,responseLoggingFilter);

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    @Test
    @Order(1)
    @DisplayName("User has been signed up")
    void testSignUpUser_whenValidDetailsProvided_returnsStatusCreated() {
        RegisterDTO registerDTO = new RegisterDTO("Nikita", "test@test.com", "123456");

        given()
                .body(registerDTO)
        .when()
                .post("/signup")
        .then()
                .statusCode(201);
    }

    @Test
    @Order(2)
    @DisplayName("User can login")
    void testLoginUser_whenValidDetailsProvided_returnsEmailAndToken() {
        LoginDTO loginDTO = new LoginDTO("test@test.com", "123456");

        given()
                .body(loginDTO)
        .when()
                .post("/login")
        .then()
                .statusCode(200)
                .body("email", Matchers.equalTo(loginDTO.getEmail()))
                .body("token", Matchers.notNullValue());
    }

}
