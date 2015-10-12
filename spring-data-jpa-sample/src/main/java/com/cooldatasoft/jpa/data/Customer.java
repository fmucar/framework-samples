package com.cooldatasoft.jpa.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 * 
 * @author Fatih Mehmet UCAR
 *
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "customer")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(value= {"new"})
public class Customer extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Size(max = 45)
	@Column(name = "username", nullable = false, length = 45)
	private String username;

	@NotEmpty
	@Size(max = 120)
	@Column(name = "`password`", nullable = false, length = 120)
	private String password;

	@Size(max = 45)
	@Column(name = "name", length = 45)
	private String name;

	@Size(max = 45)
	@Column(name = "surname", length = 45)
	private String surname;

	@Size(max = 45)
	@Column(name = "company_name", length = 45)
	private String companyName;

	@Email
	@Size(max = 45)
	@Column(name = "email", length = 45)
	private String email;

	@Size(max = 45)
	@Column(name = "phone", length = 45)
	private String phone;

}