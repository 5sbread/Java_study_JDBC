package com.bh.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bh.regions.RegionsDTO;
import com.bh.util.DBConnector;

public class CountriesDAO {

	//1. Countries의 모든 데이터 가져오기
	public ArrayList<CountriesDTO> getlist() throws Exception {

		CountriesView countriesView = new CountriesView();
		ArrayList<CountriesDTO> ar = new ArrayList();
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM COUNTRIES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			CountriesDTO countriesDTO = new CountriesDTO();
			countriesDTO.setCountry_id(rs.getString("Country_Id"));
			countriesDTO.setCountry_name(rs.getString("Country_Name"));
			countriesDTO.setRegion_id(rs.getInt("Region_id"));
			ar.add(countriesDTO);
			
		}//while
		countriesView.view(ar);
		
		//6. 자원 해제
		DBConnector.disConnect(rs, st, con);
		return ar;
	}//1
	
//=================================================================
	//2. 하나만 가져오기
	public CountriesDTO getDetail(String country_id) throws Exception{
		
		CountriesView countriesView = new CountriesView();
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
			
			countriesView.view(countriesDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return countriesDTO;
		
	}//2
	
//=================================================================
		//3. 
		public CountriesDTO getDetai(String country_id) throws Exception{
			
			CountriesView countriesView = new CountriesView();
			CountriesDTO countriesDTO = new CountriesDTO();
			
			Connection con = DBConnector.getConnection();
			String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_NAME LIKE ?";
			//Sting 타입인 경우 문자열 내의 특수기호에 알아서 ''를 넣어줌 -> '%' 가능 | '%&' 불가능			
			//'%'||?||'%' 이렇게도 가능
			//Setter 값 앞뒤로 붙여도 가능
			PreparedStatement st = con.prepareStatement(sql);
			
			//? 있으면 값 세팅
			st.setString(1, "%"+country_id+"%");
			
			st.setString(1, country_id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) { //데이터가 있으면
				countriesDTO.setCountry_id(rs.getString("country_id"));
				countriesDTO.setCountry_name(rs.getString("country_name"));
				countriesDTO.setRegion_id(rs.getInt("region_id"));
				
				countriesView.view(countriesDTO);
			}
			DBConnector.disConnect(rs, st, con);
			return countriesDTO;
			
		}//3	
	
	
}
