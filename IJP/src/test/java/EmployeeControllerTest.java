import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class EmployeeControllerTest {

    @BeforeAll
           public static void setup() {
               RestAssured.baseURI = "http://localhost:8081";
               RestAssured.basePath = "/api/employees";
           }
     
           @Test
           public void testHelloWorld() {
               given()
                   .when()
                   .get("/hello")
                   .then()
                   .statusCode(200)
                   .body(equalTo("Hello World!"));
           }


    }




//    @Test
//    public void testGetEmployeeById() {
//        EmployeeDto employeeDto = given()
//                .when()
//                .get("/api/employees/1")
//                .then()
//                .statusCode(200)
//                .extract()
//                .as(EmployeeDto.class);
//
//        // Assert specific fields of the returned EmployeeDto if needed
//        // For example, assert the employee ID
//        assertThat(employeeDto.getId(), equalTo(1L));
//    }
//
//    @Test
//    public void testCreateEmployee() {
//        EmployeeDto newEmployee = new EmployeeDto();
//        newEmployee.setName("John Doe");
//        newEmployee.setDepartment("IT");
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(newEmployee)
//                .when()
//                .post("/api/employees")
//                .then()
//                .statusCode(200);
//
//        // Optionally, assert the response body or check if the employee was saved correctly
//        // Example: Check if the new employee exists in the database
//        // EmployeeDto savedEmployee = employeeService.getEmployeeByName("John Doe");
//        // assertThat(savedEmployee.getName(), equalTo("John Doe"));
//    }
//
//    @Test
//    public void testDeleteEmployee() {
//        given()
//                .when()
//                .delete("/api/employees/1")
//                .then()
//                .statusCode(204); // No content
//
//        // Optionally, assert that the employee with ID=1 no longer exists
//    }

