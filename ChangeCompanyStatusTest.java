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
                .executeQuery("SELECT ###### FROM ####### WHERE  name LIKE \"TEST%\" AND status = \"new\" AND owner_id = ##### LIMIT 1");
                while (resultSet.next()){
        idTest = resultSet.getInt(1); }
                System.out.println(idTest);

        givenCabinet()
                .body(jsonModerate)
                .patch(urlCamp+'/'+idTest)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .body().prettyPrint();

        statusId = 1;

    }



}
