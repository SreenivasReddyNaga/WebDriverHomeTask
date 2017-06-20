package org.flight.pages;

import org.openqa.selenium.By;

public class BookingResultsPage {
	
	public By lblChooseYourflight = By.xpath("//li[text()='Choose your flight']");
	public By txtCityDetails=By.xpath("//h3[contains(text(),'Your search:')]/following-sibling::div/p/strong");
	public By txtoutboundDate=By.id("outboundDate");
	public By txtinboundDate=By.id("inboundDate");
	public By txtPassengers=By.xpath("//span[@id='inboundDate']/parent::p"); 
	public By slctBasicPrize=By.id("ControlGroupScheduleSelectView_AvailabilityInputScheduleSelectView_RadioButtonMkt1Fare1");
	

}
