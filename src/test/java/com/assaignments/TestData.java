package com.assaignments;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name = "product")
	public Object[][] product() {
		return new Object[][] {

				{"MyMoney", },
				{"FamilyAlbum"} ,
				{"ScreenSaver" }
		};
		}
	@DataProvider(name = "Hover_Content")
	public Object[][]  Hover_Content(){
		return new Object[][]{
		{"Desktops", "1800.00" },
		{"Notebooks", "1590.00" },
		{"Accessories", "3000.00" }
		};

	}
}
