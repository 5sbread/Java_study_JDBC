package com.bh.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bh.util.DBConnector;

public class EmployeesDAO {
	
	public void getlist () throws Exception {
		
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM EMPLOYEES";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setEmployee_id(rs.getInt("Employee_id"));
			employeesDTO.setFirst_name(rs.getString("First_name"));
			employeesDTO.setLast_name(rs.getString("Last_name"));
			employeesDTO.setEmail(rs.getString("Email"));
			employeesDTO.setPhone_number(rs.getInt("Phone_number"));
			employeesDTO.setHire_date(rs.getDate("Hire_date"));
			
		}
		
		
	}

}
