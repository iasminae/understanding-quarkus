package org.agoncal.fascicle.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ArtistResourceTest {

    @Test
    public void shouldGetALlArtists() {
        given()
          .when()
                .get("/artists")
          .then()
                .assertThat()
                .statusCode(is(200))
                .and()
                .body("size()", equalTo(4));
    }

    @Test
    public void shouldCountArtists() {
        given()
          .when()
                .get("/artists/count")
          .then()
                .assertThat()
                .statusCode(is(200))
                .and()
                .body(is("4"));

    }

}