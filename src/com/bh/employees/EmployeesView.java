package com.bh.employees;

import java.util.ArrayList;

public class EmployeesView {

	public void view (ArrayList<EmployeesDTO> ar) {
		System.out.println("EmployeesView");
		System.out.println("-----------------------");
		
		for(EmployeesDTO employeesDTO:ar) {
			System.out.println(employeesDTO.getEmployee_id());
			System.out.println();
		}
	}
}
