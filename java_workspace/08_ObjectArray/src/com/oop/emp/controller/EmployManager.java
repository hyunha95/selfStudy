package com.oop.emp.controller;

import com.oop.emp.model.dto.Employee;

public class EmployManager {

	public Employee[] eArr = new Employee[3];
	int totalAnnualSalary = 0;
	
	
	public void printEmployees(int n) {
		for(int i = 0; i < n; i++) {
			System.out.println("ear["+ i + "] : " + eArr[i].empInformation());
		}
		
	}
	
	public void printAnnualSalary() {
		for(Employee e : eArr) {
			int annualSalary = (int)( (e.getSalary() + (e.getSalary() * e.getBonusPoint())) * 12 );
			totalAnnualSalary += annualSalary;
			System.out.println(e.getEmpName() + "의 연봉 : " + annualSalary);
		}
		
	}
	
	public void printAnnualSalaryAvg() {
			int annualSalaryAvg = totalAnnualSalary / eArr.length;
			System.out.println("직원들의 연봉의 평균 : " + annualSalaryAvg);
	}
	
}
