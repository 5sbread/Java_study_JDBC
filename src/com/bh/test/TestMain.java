package com.bh.test;

import com.bh.countries.CountriesDAO;
import com.bh.regions.RegionsDAO;
import com.bh.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {

//		//DBConnector dbConnector = new DBConnector();
//		//ㄴ> static 사용해서 객체 만들 필요 없어짐
//		
//		try {
//			DBConnector.getConnection();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//try
		
//==========================================================		
		
//		RegionsDAO regionDAO = new RegionsDAO();
//		try {
//			regionDAO.getlist();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//==========================================================		
		
		CountriesDAO countryDAO = new CountriesDAO();
		try {
			countryDAO.getlist();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
