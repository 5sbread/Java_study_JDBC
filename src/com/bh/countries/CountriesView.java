package com.bh.countries;

import java.util.ArrayList;

public class CountriesView extends CountriesDAO{
	
	public void view(ArrayList<CountriesDTO> ar) {
		System.out.println("Country_Id\tCountry_Name\tRegion_Id");
		System.out.println("-------------------------------------");
		
		for(CountriesDTO countriesDTO:ar) {	
			System.out.print(countriesDTO.getCountry_id()+"\t\t");
			System.out.print(countriesDTO.getCountry_name()+"\t\t");
			System.out.println(countriesDTO.getRegion_id());
		}
	}
	
	
//==========================================	

	public void view(CountriesDTO countriesDTO) {
		System.out.println("Country_Id\tCountry_Name\tRegion_Id");
		System.out.println("-------------------------------------");
		System.out.print(countriesDTO.getCountry_id()+"\t\t");
		System.out.print(countriesDTO.getCountry_name()+"\t");
		System.out.println(countriesDTO.getRegion_id());
		
	}
}