package com.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pages.GoibiboFlightsPOM;
import com.Pages.GoibiboHotelsPOM;
import com.Utilities.Utilities;
import com.testBase.BaseFile;

import jxl.read.biff.BiffException;

public class GoibiboTests extends BaseFile {

	public WebDriver driver;

	@BeforeSuite
	public void initializeBrowser() throws IOException {
		this.driver = launchBrowser();
	}

	@Test (dataProvider = "flightsDataProvider")
	public void serachFlights(String Source, String Destination) {

		GoibiboFlightsPOM flights = new GoibiboFlightsPOM(driver);

		flights.searchFlights(Source, Destination);
	}
	
	@DataProvider (name = "flightsDataProvider")
	public Object[][] flightsDataProvider() throws BiffException, IOException {
		String  testInputFile = Utilities.getFileParameterValue("flightsTestInputFile");
		String  testInputSheet = Utilities.getFileParameterValue("testInputSheet");
			
		Object[][] arrayObject = Utilities.getSheetDataFromExcel(testInputFile,testInputSheet);
		return arrayObject;
	} 

	@Test (dataProvider = "hotelsDataProvider")
	public void serachHotels(String Where, String CheckInDt, String CheckoutDt, String Month) {

		GoibiboHotelsPOM hotels = new GoibiboHotelsPOM(driver);

		hotels.serachHotels(Where, CheckInDt, CheckoutDt, Month);
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "Results");
		
	}
	
	@DataProvider (name = "hotelsDataProvider")
	public Object[][] hotelsDataProvider() throws BiffException, IOException {
		String  testInputFile = Utilities.getFileParameterValue("hotelsTestInputFile");
		String  testInputSheet = Utilities.getFileParameterValue("testInputSheet");
		
		System.out.println("line no 57 "+testInputFile);
		
		Object[][] arrayObject = Utilities.getSheetDataFromExcel(testInputFile,testInputSheet);
		return arrayObject;
	}
	@AfterTest
	public void tearDown() {
		
		driver.close();
	
		
		
	}
	
}
