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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
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
@Table(name = "customer_list")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(value= {"new"})
public class CustomerList extends AbstractPersistable<Long> {
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Size(max = 45)
	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@Size(max = 300)
	@Column(name = "description", length = 300)
	private String description;

	@NotNull
	@Column(name = "created_date", nullable = false, length = 19)
	@Temporal(TIMESTAMP)
	private Date createdDate;

	@NotNull
	@Column(name = "status", nullable = false, precision = 10)
	private Integer status;

	// -----------------------------------------------------------------
	// Many to One support
	// -----------------------------------------------------------------

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// many-to-one: CustomerList.customer ==> Customer.id
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@NotNull
	@JoinColumn(name = "customer_id", nullable = false)
	@ManyToOne(cascade = { PERSIST, MERGE }, fetch = LAZY)
	private Customer customer;

}