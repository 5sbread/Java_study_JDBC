package com.bh.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bh.util.DBConnector;

public class CountriesDAO {
	
	public void getlist() throws Exception {
	
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM COUNTRIES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("COUNTRY_ID");
			String name = rs.getString("COUNTRY_NAME");
			int rid = rs.getInt("REGION_ID");
			
			System.out.println(id);
			System.out.println(name);
			System.out.println(rid);
			System.out.println("=========================");
			
		}//while
	}
}
