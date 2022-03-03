package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Utilities {

	public static String getFileParameterValue(String parameter) {

		String para =null;
		try {
			FileInputStream ff = new FileInputStream(
					"C:\\Users\\E5569498\\eclipse-workspace\\Hybrid\\src\\main\\resources\\config.properties");
			Properties properties = new Properties();
			properties.load(ff);
			para = properties.getProperty(parameter);
			
		} catch (Exception e) {

			e.printStackTrace();

		}
		return para;
		
	}

	public static String[][] getSheetDataFromExcel(String fileName, String sheetName)
			throws BiffException, IOException {

		String[][] arrayExcelData = null;

		FileInputStream fs = new FileInputStream(fileName);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(sheetName);

		int totalNoOfCols = sh.getColumns();
		int totalNoOfRows = sh.getRows();

		arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

		for (int i = 1; i < totalNoOfRows; i++) {

			for (int j = 0; j < totalNoOfCols; j++) {
				arrayExcelData[i - 1][j] = sh.getCell(j, i).getContents();
			}

		}
		
		System.out.println(arrayExcelData[1][1]);
		return arrayExcelData;
	}

	@Test
	public void testgetFileParameterValue() throws IOException {

		String par = Utilities.getFileParameterValue("sushil");
		System.out.println("line no 27" + par);
	}

}
