package org.flight.pages;

import org.openqa.selenium.By;

public class HomePage {

	public String expTitle = "Cheap flights, hotel deals, rental car | vueling.com";
	
	public By returnLabel = By.xpath("//span[text()='Return']");

	public By txtFrom = By.id("AvailabilitySearchInputXmlSearchView_TextBoxMarketOrigin1");

	public By txtDestination = By.id("AvailabilitySearchInputXmlSearchView_TextBoxMarketDestination1");

	public String cityFirst ="//div[@id='stationsList']/ul/li/a[contains(text(),'";
	public String cityNext ="')]";			

	public By adultPassengers = By.id("DropDownListPassengerType_ADT_PLUS");

	public By slctAdults = By.id("adtSelectorDropdown");
	public By slctChildren = By.id("AvailabilitySearchInputXmlSearchView_DropDownListPassengerType_CHD");

	public By slctBabies = By.id("AvailabilitySearchInputXmlSearchView_DropDownListPassengerType_INFANT");

	public By babyPopup = By.xpath("//div[@class='popupBottomSingleButton']/a");

	public By chkResidents = By.xpath("//label[@for='isResident']");

	public By slctFamilyType = By.id("AvailabilitySearchInputXmlSearchView_residentFamNumSelector");

	public By lnkSearchFlights = By.id("AvailabilitySearchInputXmlSearchView_btnClickToSearchNormal");
	
	

}
