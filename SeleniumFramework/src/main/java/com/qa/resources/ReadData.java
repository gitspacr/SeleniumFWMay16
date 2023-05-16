package com.qa.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadData {

	@DataProvider(name="passDataToExcel")
	public String[][] testData() throws Exception {
		
		File file = new File("./TestData/DataSheet.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet xsht =wb.getSheet("TestData");
		int noOfRows =xsht.getPhysicalNumberOfRows();//get the total no.of physical rows
		System.out.println(noOfRows);
		int row1 =xsht.getLastRowNum();//to exclude the header row
		System.out.println(row1);
		int noOfCols =xsht.getRow(0).getLastCellNum();
		System.out.println(noOfCols);
		String[][] data=new String[noOfRows-1][noOfCols];
		for (int i = 0; i < noOfRows-1; i++) {
			for(int j=0;j<noOfCols;j++) {
				DataFormatter df=new DataFormatter();
//				System.out.println(df.formatCellValue(xsht.getRow(i+1).getCell(j)));
				data[i][j]=df.formatCellValue(xsht.getRow(i+1).getCell(j));
//				System.out.println(xsht.getRow(i).getCell(j).getStringCellValue());
			}
			System.out.println(" ");
			
		}
		wb.close();
		fis.close();

	return data;

}
}
