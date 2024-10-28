package dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenricUtils.ExcelUtils;

public class Dataprovider_Class2
{
	@DataProvider(name = "class2")
	public Object[][] getData() throws IOException {

		/*
		 * Object[][] arr = { { "Admin", "admin123", "Valid" }, { "Sample", "admin123",
		 * "Invalid" }, { "Admin", "adm", "Invalid" }, { "adm", "123", "Invalid" }
		 * 
		 * }; return arr;
		 */

		// ------------------------------------------------------------------------------------------\\

		// get the data from excel 
		String path = ".\\src\\test\\resources\\OrangeHrm.xlsx";

		ExcelUtils xlutil = new ExcelUtils(path);

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String[][]  loginData= new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) // 1
		{
			for (int j = 0; j < totalcols; j++) // 0
			{
				loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}

		}
		return loginData;

	}

}