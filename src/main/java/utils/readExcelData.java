package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelData {
	public static void readData(String rowValue, String colValue) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\shravan\\eclipse-workspace\\CucumberHybridFramework\\src\\test\\resources\\TestData\\login.xlsx");
		// or below 2-way
		//File src=new File("\"C:\\\\Users\\\\shravan\\\\eclipse-workspace\\\\CucumberHybridFramework\\\\src\\\\test\\\\resources\\\\TestData\\\\login.xlsx\"");
		//FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook srcBook= new XSSFWorkbook(fis);
		XSSFSheet sourceSheet = srcBook.getSheetAt(0);
		String pwExcel;
		String userExcel;
		
		for(int row = 0;row<3;row++)
		
		{
			XSSFRow sourceRow = sourceSheet.getRow(row);
			XSSFCell username=sourceRow.getCell(0);
			XSSFCell password=sourceRow.getCell(1);
			userExcel = username.getStringCellValue();
			
			{
				if(password.getCellType()==CellType.STRING)
				{
					pwExcel = password.getStringCellValue();
					System.out.println("if block executed");
				}
				else
				{
					pwExcel = NumberToTextConverter.toText(password.getNumericCellValue());
					System.out.println("else block executed");
				}
			}
			System.out.println("The Username is: " +userExcel+" &"+" Password is :"+pwExcel);
			//System.out.println("The password is: " +pwExcel);

		}
		
		return;
		
	}
	
	public static void main(String args[]) throws IOException
	{
		readData(null, null);
}
	}
