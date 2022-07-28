package com.bh.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bh.regions.RegionsDTO;
import com.bh.regions.RegionsView;
import com.bh.util.DBConnector;

public class EmployeesDAO {
	
	public ArrayList<EmployeesDTO> getlist () throws Exception {
		
		EmployeesView employeesView = new EmployeesView();
		ArrayList<EmployeesDTO> ar = new ArrayList<>();
		
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
			ar.add(employeesDTO);
		}
		employeesView.view(ar);
		
		DBConnector.disConnect(rs, st, con);
		return ar;
		
	}//GETLIST
	
//----------------------------------------------------
	
	public void getSalaryInfo()throws Exception{
		
		RegionsDTO regionsDTO = new RegionsDTO();
		RegionsView regionsView = new RegionsView();
		
		//1. DB 작성
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 작성
		String sql = "SELECT SUM(SALARY),AVG(SALARY), MAX(SALARY) FROM EMPLOYEES"
				+ "WHERE // === ?";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?가 있으면 값 세팅
		
		//5. 최종 전송 후 결과처리
		ResultSet rs = st.executeQuery();
		
		
		if(rs.next()) {
			int sum = rs.getInt("SUM(SALARY)");
			double avg = rs.getDouble(2);
			int max = rs.getInt("MAX");
			System.out.println(sum);
			System.out.println(avg);
			System.out.println(max);
			
			
		}
		
		//6. 지원 해제
		DBConnector.disConnect(rs, st, con);
		return employeesDTO;	
		
		
		
	}

}
