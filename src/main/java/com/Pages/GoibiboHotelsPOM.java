package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoibiboHotelsPOM {

	@FindBy(xpath = "//input[@xpath='1']")
	WebElement radioBtIndia;

	@FindBy(xpath = "//input[@xpath='2']")
	WebElement radioBtInt;

	@FindBy(xpath = "//input[@data-testid='home-autosuggest-input']")
	WebElement searchWhere;

	@FindBy(css = ".HomePageAutosuggeststyles__SearchListItem-sc-1v6s32j-2.cFiIpU")
	List<WebElement> searchrResults;

	@FindBy(xpath = "//div[contains(text(),'Check-in')]")
	WebElement CheckIn;

	@FindBy(xpath = "//span[@data-testid='currentCalendarMonthName']")
	WebElement currentCalendarMonthName;

	@FindBy(xpath = "//span[@data-testid='calendarRightArrowBtn']")
	WebElement calendarRightArrowBtn;

	@FindBy(css = ".date_is_selectable_true")
	List<WebElement> allDates;

	@FindBy(xpath = "//button[@data-testid='searchHotelBtn']")
	WebElement searchHotelBtn;

	private WebDriver driver;

	public GoibiboHotelsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.get("https://www.goibibo.com/hotels/");
		driver.manage().window().maximize();

	}

	public void serachHotels(String Where, String CheckInDt, String CheckoutDt, String Month) {

		searchWhere.sendKeys(Where);

		for (WebElement city : searchrResults) {

			System.out.println(city.getText());

			if (city.getText().contains(Where)) {
				city.click();
				break;
			}

		}
		CheckIn.click();

		selectCalDate(Month, CheckInDt, CheckoutDt);

		searchHotelBtn.click();
		
		

	}

	private void selectCalDate(String month, String checkInDt, String checkoutDt) {

		while (!month.contains(currentCalendarMonthName.getText())) {
			calendarRightArrowBtn.click();
		}
		for (WebElement date : allDates) {

			if (date.getText().contains(checkInDt)) {
				date.click();
				break;
			}
		}
		for (WebElement date : allDates) {

			if (date.getText().contains(checkoutDt)) {
				date.click();
				break;
			}
		}
	}

}
