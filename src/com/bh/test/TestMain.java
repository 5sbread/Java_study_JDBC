package com.bh.test;

import com.bh.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		//DBConnector dbConnector = new DBConnector();
		//ㄴ> static 사용해서 객체 만들 필요 없어짐
		
		try {
			DBConnector.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
