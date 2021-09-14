package com.excelwriting;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteNewExcel {

		public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
			
		File file = new File("C:\\Users\\61435\\Documents\\Selenium\\Test.xls");
		WritableWorkbook wwk = Workbook.createWorkbook(file);
		WritableSheet wsheet = wwk.createSheet("Sheet1", 0);
		for(int i=1; i<11; i++) {
			if(i%2 != 0)
			wsheet.addCell(new Label(5, i, "Pass"));		// Label(colno, rowno, string)
			else
			wsheet.addCell(new Label(5, i, "Fail"));
		}
		wwk.write();
		wwk.close();
	}

}
