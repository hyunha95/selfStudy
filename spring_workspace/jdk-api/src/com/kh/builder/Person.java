package com.kh.builder;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
	private String id;
	private String name;
	private Date birthday;
	
//	public static class Builder {
//		private String id;
//		private String name;
//		private Date birthday;	
//		
//		public Builder id(String id) {
//			this.id = id;
//			return this;
//		}
//		
//		public Builder name(String name) {
//			this.name = name;
//			return this;
//		}
//
//		public Builder birthday(Date birthday) {
//			this.birthday = birthday;
//			return this;
//		}
//		
//		public Person build() {
//			return new Person(id, name, birthday);
//		}
//	}
//	
//	public static Builder builder() {
//		return new Builder();
//	}
}
