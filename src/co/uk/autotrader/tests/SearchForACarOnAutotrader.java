package co.uk.autotrader.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.uk.autotrader.helper.AutotraderBaseClass;
import co.uk.autotrader.pages.AutotraderHomepage;
import co.uk.autotrader.pages.AutotraderSearchResult;
import co.uk.autotrader.utilities.ExcelUtils;

public class SearchForACarOnAutotrader extends AutotraderBaseClass
{
	
	AutotraderHomepage homepage = new AutotraderHomepage();
	AutotraderSearchResult searchResult = new AutotraderSearchResult();
	
	private String postcode;
	private String distance;
	private String carMake;
	private String carModel;
	private String minPrice;
	private String maxPrice;
	private String path;
	
	@Before
	public void SetUp() throws Exception
	{
		path = "./src/co/uk/autotrader/data/AutotraderData.xlsx";
		launchBrowser("Chrome");		
		
		//The method below open excel file
		ExcelUtils.SetExcelFilePath(path);
	}
	
	@After
	public void TearDown() throws Exception
	{
		ExcelUtils.CloseWorkBook();
		closeBrowser();
	}
	
	@Test
	public void SearchForACarOnAutotraderTest() throws Exception
	{
		
			for(int row = 1; row<ExcelUtils.LastRowNum(path); row++)
			{
				postcode = ExcelUtils.GetCellData(row, 0);
				distance = ExcelUtils.GetCellData(row, 1);
				carMake = ExcelUtils.GetCellData(row, 2);
				carModel = ExcelUtils.GetCellData(row, 3);
				minPrice = ExcelUtils.GetCellData(row, 4);
				maxPrice = ExcelUtils.GetCellData(row, 5);
			
				//Given I navigate to Autotrader Homepage
				GivenINavigateAutotraderHomepage();
				//When I enter my postcode
				//homepage.WhenIEnterMyPostcode();
				homepage.WhenIEnterMyPostcode(postcode);
				//And I Select a distance
				//homepage.AndISelectADistance();
				homepage.AndISelectADistance(distance);
				//And I select a car make
				//homepage.AndISelectACarMake();
				homepage.AndISelectACarMake(carMake);
				//And I select a car model
				//homepage.AndISelectTheModelOfTheCar();
				homepage.AndISelectTheModelOfTheCar(carModel);
				//And I select a min price
				//homepage.AndISelectMinPrice();
				homepage.AndISelectMinPrice(minPrice);
				//And I select a max price
				//homepage.AndISelectMxPrice();
				homepage.AndISelectMxPrice(maxPrice);
				// And I click on search car button
				homepage.AndIClickOnSearchCarButton();
				// Then a list of cars matching my criteria is displayed
				searchResult.ThenListOfCarDisplayedIsCorrect();
			}
	}
}
