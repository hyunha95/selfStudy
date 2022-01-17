package com.kh.spring.menu.model.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String restaurant;
	private String name;
	private int price;
	private Type type; 		// enum "kr", "ch", "jp"
	private Taste taste; 	// "mild", "hot"
}
