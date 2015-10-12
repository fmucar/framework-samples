package com.cooldatasoft.jpa.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 * 
 * @author Fatih Mehmet UCAR
 *
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "person")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(value= {"new"})
public class Person extends AbstractPersistable<Long> {
	private static final long serialVersionUID = 1L;

	@Size(max = 45)
	@Column(name = "name", length = 45)
	private String name;

	@Size(max = 45)
	@Column(name = "surname", length = 45)
	private String surname;

	@Size(max = 300)
	@Column(name = "address", length = 300)
	private String address;

	@Column(name = "age", precision = 10)
	private Integer age;
}