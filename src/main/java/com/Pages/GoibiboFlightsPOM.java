package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoibiboFlightsPOM {

	@FindBy(id = "gosuggest_inputSrc")
	public WebElement flightFrom;

	@FindBy(id = "gosuggest_inputDest")
	WebElement flightDest;

	@FindBy(css = ".DayPicker-Day.DayPicker-Day--selected.DayPicker-Day--today")
	WebElement todaysDate;

	@FindBy(id = "gi_search_btn")
	WebElement searchButton;

	@FindBy(css = ".mainTxt.clearfix")
	List<WebElement> fromList;

	@FindBy(css = ".mainTxt.clearfix")
	List<WebElement> destList;
	
	private WebDriver driver;

	public GoibiboFlightsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);                       
		driver.get("https://www.goibibo.com/flights/");

	}

	public void searchFlights(String From, String Dest) {

		flightFrom.sendKeys(From);
		for (WebElement fromsrc : fromList) {

			if (fromsrc.getText().contains(From)) {
				fromsrc.click();
				break;
			}

		}
		flightDest.sendKeys(Dest);
		for (WebElement dest : destList) {

			if (dest.getText().contains(Dest)) {
				dest.click();
				break;
			}

		}
		todaysDate.click();
		searchButton.click();
		

	}
}
