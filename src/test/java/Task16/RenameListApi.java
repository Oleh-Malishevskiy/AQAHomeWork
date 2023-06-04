package Task16;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
public class RenameListApi {
    private static String requestBody = "{\n" +
            "  \"name\": \"ListNewName\" \n}";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.trello.com";
    }

    @Test
    public void RenameList() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put("/1/lists/647c7faebd5823a086fa9f42?key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("ListNewName", response.jsonPath().getString("name"));
        System.out.println(response.getBody().asString());
    }
}
