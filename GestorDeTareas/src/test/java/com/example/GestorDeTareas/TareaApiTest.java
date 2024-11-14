package com.example.GestorDeTareas;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TareaApiTest {

    private static final String BASE_URL = "http://localhost:8080/api/tareas";

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void shouldCreateTarea() {
        String requestBody = """
                {
                    "titulo": "Nueva Tarea"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("titulo", equalTo("Nueva Tarea"));
    }

    @Test
    public void shouldGetAllTareas() {
        when()
                .get()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    public void shouldGetTareaById() {
        int tareaId = 1;

        when()
                .get("/" + tareaId)
                .then()
                .statusCode(200)
                .body("id", equalTo(tareaId));
    }

    @Test
    public void shouldUpdateTarea() {
        int tareaId = 1;
        String requestBody = """
                {
                    "titulo": "Tarea actualizada"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("titulo", equalTo("Tarea actualizada"));
    }

    @Test
    public void shouldDeleteTarea() {
        int tareaId = 1;

        when()
                .delete("/" + tareaId)
                .then()
                .statusCode(204);
    }
}