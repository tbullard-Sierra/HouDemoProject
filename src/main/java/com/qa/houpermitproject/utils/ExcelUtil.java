package com.qa.houpermitproject.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.houpermitproject.constants.Constants;

public class ExcelUtil {
	
	public static String filePath = Constants.ROOFING_PERMIT_TEST_DATA_SHEET_PATH;
	public static Workbook book;
	public static Sheet sheet;
	
	
	/**
	 * this method is used to read data from excel
	 * @param sheetName
	 * @return
	 */
	public static Object[][] readTestData(String filePath,String sheetName) {
		
		Object [][] data =null;
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			
			book = WorkbookFactory.create(fis);
			sheet = book.getSheet(sheetName);
			
			data  = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0; i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
					
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return data;
	}
	
	
	/**
	 * this method is used to write into excel
	 * @param sheetName
	 */
	public static void writeDataIntoExcel(String sheetName,String results) {
		
		//String results = null;
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			book = WorkbookFactory.create(fis);
			sheet = book.getSheet(sheetName);
			
			int lastCellNo = sheet.getRow(0).getLastCellNum();
			Cell resultsCell = sheet.getRow(0).createCell(lastCellNo+3);
			resultsCell.setCellValue("Results");
			
			
			for(int i=1;i<=sheet.getLastRowNum();i++) {
				if(results.equalsIgnoreCase("True")) {
					
					resultsCell.setCellValue("Pass");
					
				}else {
					resultsCell.setCellValue("Fail");
				}
			}
				FileOutputStream fos = new FileOutputStream(filePath);
				book.write(fos);
				
				
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void updateTestResult(int row, String result) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook;
		try {
			workbook = WorkbookFactory.create(file);
			
			 Sheet sheet = workbook.getSheet(Constants.ROOFING_PERMIT_TEST_DATA_SHEET_NAME);

		        Row rowData = sheet.getRow(row);
		        Cell cell = rowData.createCell(rowData.getLastCellNum());
		        cell.setCellValue(result);

		        FileOutputStream fileOut = new FileOutputStream(filePath);
		        workbook.write(fileOut);
		        fileOut.close();

		        ((FileInputStream) workbook).close();
		        file.close();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
       
    }

}
