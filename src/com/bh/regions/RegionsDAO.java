package com.bh.regions;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bh.util.DBConnector;

import oracle.jdbc.proxy.annotation.Pre;

public class RegionsDAO {
	
	//1. Regions의 모든 데이터 가져오기
	
	public void getlist () throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "SELECT * FROM REGIONS";
		
		//3. QUERY문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4.
		
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		
		while(rs.next()) {
			int id = rs.getInt("Region_id");
		//리턴 타입은 int	
			
			String name = rs.getString("Region_name");
			
			System.out.println(id);
			System.out.println(name);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
