package com.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POI {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\chromedriver\\POI_TestData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("TestData");

		XSSFRow row = sheet.getRow(1);

		XSSFCell cell = row.getCell(3);

		String val = cell.getStringCellValue();

		System.out.println(val);

	}

}
