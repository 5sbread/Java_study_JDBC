package com.bh.regions;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bh.util.DBConnector;

import oracle.jdbc.proxy.annotation.Pre;

public class RegionsDAO {
	
	//1. Regions의 모든 데이터 가져오기
	public ArrayList<RegionsDTO> getlist () throws Exception {
		
		RegionsView regionsView = new RegionsView();
		ArrayList<RegionsDTO> ar = new ArrayList();
		
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "SELECT * FROM REGIONS";
		
		//3. QUERY문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			RegionsDTO regionsDTO = new RegionsDTO(); //while 안에서만 필요해서 여기에 선언
			regionsDTO.setRegion_id(rs.getInt("Region_id"));
			//리턴 타입은 int	
			regionsDTO.setRegion_name(rs.getString("Region_Name"));
			ar.add(regionsDTO);
		
		}//while
		regionsView.view(ar);

		//6. 자원 해제
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
//=================================================================
	//2. Regions에서 하나의 결과만 가져옴 (row)
		public RegionsDTO getDetail(int region_id) throws Exception{
			
			RegionsDTO regionsDTO = new RegionsDTO();
			RegionsView regionsView = new RegionsView();
			
			//1.DB 연결
			Connection con = DBConnector.getConnection();
			
			//2. SQL문 작성
			String sql = "SELECT * FROM REGIONS WHERE REGION_ID=?";
														//id는 다른 값을 원할 때마다 바꿔줘야 함 -> 매개변수로 받음
														//변수로 들어갈 값을 ?로 처리
			//3. 미리 전송
			PreparedStatement st = con.prepareStatement(sql);
			
			//4. ? 값 세팅
			//WHERE NUM BETWEEN ? AND ?;
			//					1번	  2번 <- 앞에서 부터 숫자
			st.setInt(1, region_id); //Oracle은 1부터 인덱스 시작
			
			//5. 최종 전송 후 결과 처리
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				regionsDTO.setRegion_id(rs.getInt(1)); //sql에서 실행했을 때 나오는 열 번호
				regionsDTO.setRegion_name(rs.getString(2));
				
				regionsView.view(regionsDTO);
			}
			
			//6. 자원 해제
			DBConnector.disConnect(rs, st, con);
			return regionsDTO;
		}//2


}
