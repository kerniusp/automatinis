import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiTesting {

    private static int id;





//    @Test
//    public void test(){
//        given()
//                .when()
//                .get("https://gorest.co.in/public/v2/users")
//                .then()
//                .log().body();
//
//    }

    @Test
    @Order(1)
    public void createUser(){

        String user = """
            {
                "name": "Saulius Mangruda",
                "email": "sauliuss@gmail.com",
                "gender": "male",
                "status": "active"
            }
            """;
    id =
            given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + "05236993a6fad8b6f88fe35fa3b51df2f1bcd5c5fe1c4daf3ab7b3a10177f758")
                .body(user)
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .log().all()
                    .assertThat()
                    .statusCode(201)
                .extract().path("id");




    }

    @Test
    @Order(2)
    public void extractCreatedUser(){

        given()
                .headers("Authorization", "Bearer " + "05236993a6fad8b6f88fe35fa3b51df2f1bcd5c5fe1c4daf3ab7b3a10177f758")
                .get("https://gorest.co.in/public/v2/users/" + id)
                .then()
                .log().all();



    }

    @Test
    @Order(3)
    public void deleteCreatedUser(){
        given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + "05236993a6fad8b6f88fe35fa3b51df2f1bcd5c5fe1c4daf3ab7b3a10177f758")
                .delete("https://gorest.co.in/public/v2/users/" + id);

    }

    @Test
    @Order(4)
    public void extractCreatedUsers(){

        given()
                .headers("Authorization", "Bearer " + "05236993a6fad8b6f88fe35fa3b51df2f1bcd5c5fe1c4daf3ab7b3a10177f758")
                .get("https://gorest.co.in/public/v2/users/" + id)
                .then()
                .log().body();

    }
}
