package com.excelwriting;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WriteExistingExcel {
	
	public static void main(String[] args) throws BiffException, WriteException, IOException {

		Workbook workbook = Workbook.getWorkbook(new File("Employee.xls"));
		File nwfile = new File("C:\\Users\\61435\\Documents\\Selenium\\newEmp.xls");
		WritableWorkbook copywk = Workbook.createWorkbook(nwfile, workbook);  //create a new excel and copy from existing
		WritableSheet wsheet = copywk.getSheet("Sheet1");
		for(int i=1; i<11; i++) {
	//		for(int j=3; j<=3; j++) {
			if(i%2 !=0)
				wsheet.addCell(new Label(3, i, "Pass"));	// Label(colno, rowno, string)
			else
				wsheet.addCell(new Label(3, i, "Failed"));
	//		}
		}
		copywk.write();
		copywk.close();
	}

}
