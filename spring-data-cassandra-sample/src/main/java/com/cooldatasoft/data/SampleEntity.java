package com.cooldatasoft.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("sample")
public class SampleEntity {

	@PrimaryKey
	private Long id;
	private String name;
	private String surname;

}
