package API.RegistrationAutorization;

import com.jayway.restassured.http.ContentType;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PersonalCabinetPatchTest extends SSCore {

//    https://habr.com/ru/post/421005/
    @Test
    public void runTest() {
        caseId = "15381228";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer " + getTokenSS())
                .body(bodyInfoAboutJson)
                .patch(userUrl)
                .then()
                .body("email", equalTo("test13@test.com"))
                .statusCode(200)
                .extract()
                .response()
                        .prettyPrint();

        statusId = 1;
    }


}