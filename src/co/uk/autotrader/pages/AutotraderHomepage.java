package co.uk.autotrader.pages;

import org.openqa.selenium.WebElement;

import co.uk.autotrader.helper.AutotraderBaseClass;

public class AutotraderHomepage extends AutotraderBaseClass
{
	private WebElement Postcode;
	private WebElement Distance;
	private WebElement Make;
	private WebElement Model;
	private WebElement MinPrice;
	private WebElement MaxPrice;
	private WebElement SearchCarButton;
	
	public void WhenIEnterMyPostcode() throws Exception 
	{
		Postcode = getElementById("postcode");
		Postcode.clear();
		Postcode.sendKeys("OL9 8LE");
	}
	
	public void WhenIEnterMyPostcode(String code) throws Exception 
	{
		Postcode = getElementById("postcode");
		Postcode.clear();
		Postcode.sendKeys(code);
	}
	
	
	public void AndISelectADistance()  throws Exception
	{
		Distance = getElementById("radius");
		
		selectByText(Distance, "Within 30 miles");
	}
	
	public void AndISelectADistance(String distanceTo)  throws Exception
	{
		Distance = getElementById("radius");
		
		selectByText(Distance, distanceTo);
	}
	
	public void AndISelectACarMake() throws Exception
	{
		Make = getElementById("searchVehiclesMake");
		
		selectByValue(Make, "KIA");
	}
	
	public void AndISelectACarMake(String carMake) throws Exception
	{
		Make = getElementById("searchVehiclesMake");
		
		selectByValue(Make, carMake);
	}
	
	public void AndISelectTheModelOfTheCar() throws Exception
	{
		Model = getElementById("searchVehiclesModel");
		selectByValue(Model, "SPORTAGE");
	}
	
	public void AndISelectTheModelOfTheCar(String carModel) throws Exception
	{
		Model = getElementById("searchVehiclesModel");
		selectByValue(Model, carModel);
	}
	
	public void AndISelectMinPrice() throws Exception
	{
		MinPrice = getElementById("searchVehiclesPriceFrom");
		
		selectByValue(MinPrice, "19000");
	}
	
	public void AndISelectMinPrice(String loPrice) throws Exception
	{
		MinPrice = getElementById("searchVehiclesPriceFrom");
		
		selectByValue(MinPrice, loPrice);
	}
	
	
	public void AndISelectMxPrice() throws Exception
	{
		MaxPrice = getElementById("searchVehiclesPriceTo");
		
		selectByValue(MaxPrice, "22500");
	}
	
	public void AndISelectMxPrice(String mxPrice) throws Exception
	{
		MaxPrice = getElementById("searchVehiclesPriceTo");
		
		selectByValue(MaxPrice, mxPrice);
	}
	
	public void AndIClickOnSearchCarButton() throws Exception
	{
		SearchCarButton = getElementById("search");
		
		SearchCarButton.click();
	}
	
}
