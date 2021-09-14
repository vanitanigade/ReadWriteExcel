package com.excelreading;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelWithArray {
	
	public static String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fis);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();							//-1	if want to read column names then do these changes
			int totalNoOfRows = sh.getRows();

			arrayExcelData = new String[totalNoOfRows][totalNoOfCols];		//rows-1

			for (int i= 0 ; i < totalNoOfRows; i++) {						//i=1

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i][j] = sh.getCell(j, i).getContents();	//[i-1]
				}
			}
		} catch (IOException | BiffException  e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

	public static void main(String[] args) {
		String[][] data = getExcelData("Employee.xls", "Sheet1");
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				System.out.print(data[i][j] + "         ");
			}
			System.out.println();
		}

	}

}
