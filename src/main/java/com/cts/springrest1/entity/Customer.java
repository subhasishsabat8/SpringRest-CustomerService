package com.cts.springrest1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Max(value = 200, message = "Provide proper Id")
	private long id;

	@Column(name = "name")
	@NotEmpty(message = "Name can not be empty")
	private String name;

	@Column(name = "email")
	@Email(message = "Provide proper Email address")
	@NotEmpty(message = "Email can not be empty")
	private String email;

	@Column(name = "contact")
	@Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Provide proper Contact number")
	private String contact;
}
