package org.sid.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Task {
	@Id
	@GeneratedValue
	private Long id;
	private String taskname;

}
