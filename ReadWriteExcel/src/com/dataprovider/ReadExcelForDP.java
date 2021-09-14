package com.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelForDP {
	
	public static String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fis);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns()-1;
			int totalNoOfRows = sh.getRows();

			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];

			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}
			}
		} catch (IOException | BiffException  e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}


}
