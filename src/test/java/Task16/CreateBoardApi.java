package Task16;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBoardApi {
//    V9.
//    Create a new board. Check that the API call returns a success status code and that the board is created with the name provided in the API call.
//    Create a new list on the board. Check that the API call returns a success status code and that the list is created with the name provided in the API call.
//    Update the name of the list. Check that the API call returns a success status code and that the name of the list is updated as expected.
//    Delete the list from the board. Check that the API call returns a success status code and that the list is deleted from the board.



    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.trello.com";
    }

    @Test
    public void CreateBoardTest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .when()
                .post("/1/boards/?name=NewBoardTest1&key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("NewBoardTest1",response.jsonPath().getString("name"));
        System.out.println(response.getBody().asString());
    }
}
