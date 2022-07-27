package com.bh.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bh.util.DBConnector;

public class CountriesDAO {

	//1. Countries의 모든 데이터 가져오기
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
		
		//6. 자원 해제
		DBConnector.disConnect(rs, st, con);
	}//1
	
//=================================================================
	//2. 하나만 가져오기
	public void getDetail(String country_id) throws Exception{
		
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, country_id);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			String cId = rs.getString(1);
			String cName = rs.getString(2);
			
			System.out.println(cId);
			System.out.println(cName);
		}
		DBConnector.disConnect(rs, st, con);
	}//2
	
	
}
