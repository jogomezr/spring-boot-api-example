package com.jogomezr.examples.restapi.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Represents a new student")
public class NewStudent {

	@ApiModelProperty(value = "First name of the student", required = true, example = "Peter")
	private String firstName;

	@ApiModelProperty(value = "Last name of the student", required = true, example = "Griffin")
	private String lastName;

	@ApiModelProperty(value = "Age of the student", required = true, example = "58")
	private Integer age;
	
	public NewStudent() {
	}

	public NewStudent(String firstName, String lastName, Integer age) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;

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
