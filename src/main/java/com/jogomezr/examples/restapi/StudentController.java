package com.jogomezr.examples.restapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jogomezr.examples.restapi.domain.NewStudent;
import com.jogomezr.examples.restapi.domain.Student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.SwaggerDefinition.Scheme;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
@Validated
@Api(value = "students")
@SwaggerDefinition(info = @Info(
		description = "The students API",
		version = "v2",
		title = "The students REST API example",
		contact = @Contact(name = "Sponge-Bob", email = "sponge-bob@swagger.io", url = "http://swagger.io"),
		license = @License(name = "Apache 2.0", url = "http://www.apache.org")),
		host = "mycompany.com",
		schemes =  Scheme.HTTPS
)
public class StudentController {

	@ApiOperation(value = "Retrieve all students", nickname = "getAllStudents", notes = "Return a list of available students", response = Student.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "returns a list containing the available students", response = Student.class, responseContainer = "List") })
	@RequestMapping(value = "/students", produces = { "application/json" }, method = RequestMethod.GET)
	public List<Student> getAllStudents() {

		return Stream.of(new Student(1L, "Peter", "Griffin", 58), new Student(2L, "Peter", "Griffin", 58))
				.collect(Collectors.toList());

	}

	@ApiOperation(value = "Retrieve a student by ID", nickname = "getStudentById", notes = "By passing in the appropriate identifier, you can get the student details", response = Student.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "returns the student details for the provided identifier", response = Student.class),
			@ApiResponse(code = 400, message = "Bad input parameters"),
			@ApiResponse(code = 404, message = "Not found") })
	@GetMapping(path = "/students/{id}", produces = { "application/json" })
	public Student getStudentById(@ApiParam(value = "Identifier of the student", required = true) @PathVariable("id") Long id) {
		return new Student(id, "Peter", "Griffin", 58);
	}

	@ApiOperation(value = "Create a new student", nickname = "addStudent", notes = "Creates a new student based on the provided data", response = Student.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "returns the new student details", response = Student.class),
			@ApiResponse(code = 400, message = "Bad input parameters") })
	@PostMapping(path = "/students", consumes = { "application/json" }, produces = { "application/json" })
	public Student addStudent(@ApiParam(value = "Data to create a new student", required = true) @RequestBody(required = true) NewStudent student) {
		return new Student(Double.doubleToLongBits(Math.random()), student.getFirstName(), student.getLastName(),
				student.getAge());
	}

}
