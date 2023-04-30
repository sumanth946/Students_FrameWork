package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payloads.Students;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StudentsEndPoints {

	// method to get all students
	public static Response getAllStudents() {
		Response res = given().when().get(Routes.getAllUrl);

		return res;
	}

	// method to get to get single student

	public static Response getStudent(int iD) {

		Response res = given().pathParam("StudentID", iD)

				.when().get(Routes.getUrl);
		return res;
	}

	// method to create single student

	public static Response createStudent(Students payload) {

		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.postUrl);

		return res;
	}

	// method to update single student

	public static Response updateStudent(Students payload , int id) {

		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
				.pathParam("StudentID", id)
				.when()
				.put(Routes.putUrl);

		return res;
	}

	// method to delete single student

	public static Response deleteStudent(int id) {

		Response res = given()
						.pathParam("StudentID", id)

				.when().delete(Routes.delUrl);

		return res;
	}

}
