package org.epam.tat;

import org.commonlibrary.DatePickerClass;
import org.commonlibrary.HelperClass;
import org.commonlibrary.WebDriverBaseClass;
import org.flight.pages.BookingResultsPage;
import org.flight.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FlightBookingTest extends WebDriverBaseClass {
	
	private SoftAssert softAssert = new SoftAssert();
	private String fromCity = "Almeria";
	private String destinationCity = "Barcelona";
	private String outBoundDate = "22/6/2017";
	private String inBoundDate = "21/7/2017";
	private String adultsCount = "2";
	private String childrenCount = "2";
	private String babiesCount = "2";
	private String familyType = "General Large Family";
	private DatePickerClass datePicker;
	private String selectedFromCity="Almeria (LEI)";
	private String selectedDestinationCity= "Barcelona (BCN)";
	

	@Test
	public void flightBookingTest() {
		HomePage homePage = new HomePage();
		HelperClass helper = new HelperClass(driver);
		Assert.assertEquals(driver.getTitle(), homePage.expTitle);
		driver.findElement(homePage.returnLabel).click();

		// Select From and Destination Cities
		By lnkCityFrom=By.xpath(homePage.cityFirst+fromCity+homePage.cityNext);
		System.out.println(lnkCityFrom);
		driver.findElement(homePage.txtFrom).sendKeys(fromCity);
		driver.findElement(lnkCityFrom).click();
		helper.waitForElementVisible(homePage.txtDestination, 20);
		By lnkCityDestination=By.xpath(homePage.cityFirst+destinationCity+homePage.cityNext);
		driver.findElement(homePage.txtDestination).sendKeys(destinationCity);
		System.out.println(lnkCityDestination);
		driver.findElement(lnkCityDestination).click();

		// Select OutBoundDate and InBoundDate
		datePicker = new DatePickerClass(driver);
		datePicker.selectDate(outBoundDate);
		datePicker.selectDate(inBoundDate);

		// Select Passengers details
		driver.findElement(homePage.adultPassengers).click();		
		WebElement adults = driver.findElement(homePage.slctAdults);
		helper.selectOptionByText(adults, adultsCount);
		WebElement chlidren = driver.findElement(homePage.slctChildren);
		helper.selectOptionByText(chlidren, childrenCount);
		WebElement babies = driver.findElement(homePage.slctBabies);
		helper.selectOptionByText(babies, babiesCount);
		//helper.waitForElementVisible(homePage.babyPopup, 20);
		WebElement babyPopup=driver.findElement(homePage.babyPopup);
		helper.jsExecutor(babyPopup);

		// Select Family Type
		helper.waitForElementVisible(homePage.chkResidents, 20);
		driver.findElement(homePage.chkResidents).click();
		WebElement objfamilyType = driver.findElement(homePage.slctFamilyType);
		helper.selectOptionByText(objfamilyType, familyType);

		// Search for Flights
		driver.findElement(homePage.lnkSearchFlights).click();

	}
	
	@Test(dependsOnMethods={"flightBookingTest"})
	public void validateFlightBookingTest(){
		BookingResultsPage bookingPage=new BookingResultsPage();
		String tabStatus=driver.findElement(bookingPage.lblChooseYourflight).getAttribute("class");
		softAssert.assertEquals(tabStatus, "selected");
		
		String fromAndDestination=driver.findElement(bookingPage.txtCityDetails).getText();
		softAssert.assertEquals(fromAndDestination, selectedFromCity+" - "+selectedDestinationCity);
		
		String passangersDetails=driver.findElement(bookingPage.txtPassengers).getText();
		String[] data=datePicker.splitData(passangersDetails, "|");
		softAssert.assertEquals(data[0], outBoundDate+" - "+inBoundDate);
		
		softAssert.assertEquals(data[1], adultsCount+" Adults, "+childrenCount+" Children, "+babiesCount+" Babies");
		
		softAssert.assertAll();
		
	}

}
