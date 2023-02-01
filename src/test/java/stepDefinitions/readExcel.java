package stepDefinitions;
import java.io.IOException;

import io.cucumber.java.en.Given;
import utils.readExcelData;

public class readExcel extends readExcelData{

	@Given("User is on excel sheet")
	public void User_is_on_excel_sheet() throws IOException
	{
		readData(null, null);
	}
}
