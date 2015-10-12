package com.cooldatasoft.rest.data;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.Data;

@Data
public class SampleEntity {
	@JsonProperty
	private Long id;
	@JsonProperty
	private String field1;
	@JsonProperty
	private String field2;
}
