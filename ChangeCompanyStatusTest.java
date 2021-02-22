package API.Campaigns;


import API.RegistrationAutorization.SSCore;
import org.json.JSONObject;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangeCompanyStatusTest extends SSCore {
    int idTest = 112;
    public static String jsonModerate = new JSONObject()
            .put("transition", "moderate")
            .toString();

    @Test
    public void runTest() throws SQLException {
        caseId = "15381253";
//        addTestResultHeader("Смена статуса компании/ SS");

        ResultSet resultSet =
                getStatementFromDbSS()
                .executeQuery("SELECT id FROM ss.campaign WHERE  name LIKE \"TEST_Camp%\" AND status = \"new\" AND owner_id = 85 LIMIT 1");
                while (resultSet.next()){
        idTest = resultSet.getInt(1); }
                System.out.println(idTest);

        String response = givenCabinet()
                .body(jsonModerate)
                .patch(urlCamp+'/'+idTest)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .body().prettyPrint();

        System.out.println(response);
        statusId = 1;

    }



}
