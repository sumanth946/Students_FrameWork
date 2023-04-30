package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StudentsEndPoints;
import api.payloads.Students;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class StudentsTest {
	
	/*
	 * id
	 * name
	 * lastname
	 */
	
	Faker faker;
	Students payLoad;
	
	@BeforeClass
	void setUpData() {
		faker=new Faker();
		payLoad=new Students();
		
		payLoad.setLastName(faker.name().lastName());
		payLoad.setName(faker.name().name());
		
	}
	
	@Test(priority=1)
	void getAllStudents() {
		Response res =StudentsEndPoints.getAllStudents();
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		//res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Students Schema.json"));
		
	}
	
	@Test(priority=2)
	void createStudent() {
		payLoad.setId(faker.idNumber().hashCode());
		Response res = StudentsEndPoints.createStudent(payLoad);
		res.then().log().all();
		//Assert.assertEquals(res.getStatusCode(), 201);
	}
	
	@Test(priority=3)
	void getStudent() {
		int ID = this.payLoad.getId(); 
		Response res = StudentsEndPoints.getStudent(ID);
		res.then().log().all();
	}
	
	@Test(priority=4)
	void updateStudent() {
		payLoad.setLastName(faker.name().lastName());
		payLoad.setName(faker.name().name());
		int ID = this.payLoad.getId(); 
		Response res = StudentsEndPoints.updateStudent(payLoad, ID);
		res.then().log().all();
		
	}
	
	@Test(priority=5)
	void delStudent() {
		int ID = this.payLoad.getId(); 
		System.out.println("delete id === "+ID);
		Response res = StudentsEndPoints.deleteStudent(ID);
		res.then().log().all();
	}
	


}
