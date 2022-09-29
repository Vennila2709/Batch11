package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static void main(String[] args) throws IOException {
		
		//Excel update
		File excelLoc=new File("C:\\Users\\Admin\\Batch9\\Employee\\Resources\\Sample.xlsx");
		FileInputStream stream=new FileInputStream(excelLoc);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s=w.getSheet("Data");
		Row r=s.getRow(0);
		Cell c=r.getCell(0);
		String s1=c.getStringCellValue();
		if(s1.equals("Vennila")) {
			 c.setCellValue("Nila");
		}
        FileOutputStream output=new FileOutputStream(excelLoc);
        w.write(output);
        w.close();
	}

}

