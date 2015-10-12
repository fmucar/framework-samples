package com.cooldatasoft.jpa.data;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

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
@Table(name = "customer_list_phone")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(value= {"new"})
public class CustomerListPhone extends AbstractPersistable<Long> {
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "created_date", nullable = false, length = 19)
	@Temporal(TIMESTAMP)
	private Date createdDate;

	@Digits(integer = 10, fraction = 0)
	@NotNull
	@Column(name = "status", nullable = false, precision = 10)
	private Integer status;

	// -----------------------------------------------------------------
	// Many to One support
	// -----------------------------------------------------------------

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: CustomerListPhone.person ==> Person.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@NotNull
	@JoinColumn(name = "person_id", nullable = false)
	@ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
	private Person person;

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: CustomerListPhone.customerList ==> CustomerList.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@NotNull
	@JoinColumn(name = "customer_list_id", nullable = false)
	@ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
	private CustomerList customerList;

}