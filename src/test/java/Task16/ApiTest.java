package Task16;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {
//    V10.
//    Create a new card on a board. Check that the API call returns a success status code and that the card is created with the name provided in the API call.
//    Add a due date to the card. Check that the API call returns a success status code and that the due date is added to the card.
//    Update the due date of the card. Check that the API call returns a success status code and that the due date of the card is updated as expected.
//    Delete the due date from the card. Check that the API call returns a success status code and that the due date is removed from the card.


    private static String requestBody = "{\n" +
            "  \"name\": \"CreateTestCard\",\n" +
            "  \"desc\": \"TestCreate\",\n" +
            "  \"idList\": \"6460c94273877a9903414962\" \n}";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.trello.com";
    }

    @Test
    public void postRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/1/cards?idList=5abbe4b7ddc1b351ef961414&key=1e166e6bb1ca9d215203a0d66d771f8e&token=ATTAa9181d91daad8f88c8d5ec34e261775611b7a7ae8f26f72bc6d49335743613d7EEC813F8")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("CreateTestCard", response.jsonPath().getString("name"));
        Assertions.assertEquals("TestCreate", response.jsonPath().getString("desc"));
        Assertions.assertEquals("6460c94273877a9903414962", response.jsonPath().getString("idList"));
//        Assertions.assertEquals("101", response.jsonPath().getString("id"));
    }
}
