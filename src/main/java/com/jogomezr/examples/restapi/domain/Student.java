package com.jogomezr.examples.restapi.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Represents a student")
public class Student {

	@ApiModelProperty(value = "Identifier of the student", required = true, example = "569898874")
	private Long id;

	@ApiModelProperty(value = "First name of the student", required = true, example = "Peter")
	private String firstName;

	@ApiModelProperty(value = "Last name of the student", required = true, example = "Griffin")
	private String lastName;

	@ApiModelProperty(value = "Age of the student", required = true, example = "58")
	private Integer age;

	public Student() {
		this.id = -1L;
	}

	public Student(Long id, String firstName, String lastName, Integer age) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
