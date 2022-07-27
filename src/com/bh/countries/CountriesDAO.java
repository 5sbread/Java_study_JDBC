package com.bh.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bh.util.DBConnector;

public class CountriesDAO {

	//1. Countries의 모든 데이터 가져오기
	public void getlist() throws Exception {

		ArrayList<CountriesDTO> ar = new ArrayList();
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
		
		//6. 자원 해제
		DBConnector.disConnect(rs, st, con);
	}//1
	
//=================================================================
	//2. 하나만 가져오기
	public CountriesDTO getDetail(String country_id) throws Exception{
		
		CountriesDTO countriesDTO = new CountriesDTO();
		
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, country_id);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) { //데이터가 있으면
			countriesDTO.setCountry_id(rs.getString("country_id"));
			countriesDTO.setCountry_name(rs.getString("country_name"));
			countriesDTO.setRegion_id(rs.getInt("region_id"));
			
			CountriesView.
		}
		DBConnector.disConnect(rs, st, con);
		return countriesDTO;
		
	}//2
	
	
}
