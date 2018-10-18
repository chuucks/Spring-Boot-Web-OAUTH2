package com.codesolt.springbootweb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Talk {

	@Id
	@Column(name="EVENT_ID", updatable = false, nullable = false)
	private Long eventId;
	private String name;
	private String speaker;
	private String resume;
}
