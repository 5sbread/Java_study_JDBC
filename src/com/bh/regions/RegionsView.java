package com.bh.regions;

import java.util.ArrayList;

public class RegionsView extends RegionsDAO{

	public void view (ArrayList<RegionsDTO> ar) {
		System.out.println("Region_ID\tRegion_Name");
		System.out.println("-----------------------------");
		
		for(RegionsDTO regionsDTO:ar) {
			System.out.print(regionsDTO.getRegion_id()+"\t\t");
			System.out.println(regionsDTO.getRegion_name());
			System.out.println("-----------------------------");
		}
	}
	
	
	public void view (RegionsDTO regionsDTO){

		System.out.println("Region_ID\tRegion_Name");
		System.out.println("-----------------------------");
		System.out.print(regionsDTO.getRegion_id()+"\t\t");
		System.out.println(regionsDTO.getRegion_name());
		System.out.println("-----------------------------");
		System.out.println();
	
	}

}
