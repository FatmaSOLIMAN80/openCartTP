package utils;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {

	// remove hardcoded wait time in Base class
	public static final int Implicit_WaitTime = 10;
	public static final int pageLoadTime = 5;

	// generer un nouveau email à chaque nouvelle execution de test avec le
	// timeStamp
	// utiliser pour débloquer les tentatives successives de login avec invalid
	// email
	// uses SimpleDateFormat to achieve a more precise timestamp that includes
	// milliseconds
	// SimpleDateFormat approach is better than the to string method of the date
	// because it offers more granularity (down to milliseconds). It can help ensure
	// uniqueness, especially when tests are executed in rapid succession.
	// public static String generateTimeStamp(String prefix) {
	// Date date = new Date();
	// String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
	// return prefix+timeStamp+"@gmail.com";
	// }

	public static String generateTimeStamp(String prefix) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE_MMM_dd_HH_mm_ss_SSS_Z_yyyy");
		String timeStamp = sdf.format(new Date());
		return prefix + timeStamp + "@gmail.com";
	}

	// Apache POI is a popular Java library used to read and write Microsoft Office
	// documents, including Excel files (both XLS and XLSX).
//When you're working with the newer Excel format .xlsx, you'd use the XSSFWorkbook, XSSFSheet, and XSSFRow classes, 
	// which are part of the org.apache.poi.xssf.usermodel package.
	// we put in the pom.xml the dependecies of Apache Poi, Apache Poi ooxml and
	// Apache Poi ooxml schemas
	public static Object[][] getTestDataFromExcel(String sheetName) {
		// excel file path
		File excelFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\testData\\Tp_OpenCart_TestData.xlsx");
		// make this object global
		// initialize the value to null
		XSSFWorkbook workbook = null;
		// refer the excel file
		try {
			FileInputStream fisExcel = new FileInputStream(excelFile);
			// refer the input file
			workbook = new XSSFWorkbook(fisExcel);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// The XSSFSheet class in Apache POI represents a sheet in an Excel workbook
		// This class provides methods to read and write data, manage rows, and
		// manipulate various sheet settings.
		XSSFSheet sheet = workbook.getSheet(sheetName);
		// get sheet rows number
		int rows = sheet.getLastRowNum();
		// get sheet columns number from row
		int cols = sheet.getRow(0).getLastCellNum();
		// method return
		Object[][] data = new Object[rows][cols];
		// boucle imbriquee
		// parcourir les lignes
		for (int i = 0; i < rows; i++) {
			// The XSSFRow class in Apache POI represents a row in an Excel sheet
			// row index begins with 0 which is the header, we want the first row contains
			// the actual data
			// so we write i+1 to exclude the sheet header contains the titles
			// get sheet rows
			XSSFRow row = sheet.getRow(i + 1);
			// parcourir les colonnes
			for (int j = 0; j < cols; j++) {
				// get row coloumns
				// The XSSFCell class in Apache POI represents a cell in an Excel sheet
				// This will return a blank cell instead of null if the cell is missing
				XSSFCell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK); 
				// these cell values are different types
				// return cell type
				// CellType is an enumeration in the Apache POI library that represents the type
				// of data that a cell contains.
				CellType cellType = cell.getCellType();
				// creating switch cases for each celle type we have: string, numeric
				switch (cellType) {
				case STRING:
					// retrieve the data from excel file then assign it to the 2D array: Object [][]
					// data
					data[i][j] = cell.getStringCellValue();
					break;
				// cell.getNumericCellValue(): This method returns the value of an Excel cell as
				// a double
				case NUMERIC:
					// to avoid the return of password value like that: 12345.00
					// (int)cell.getNumericCellValue(): This is casting the double value to an int.
					// This will remove any decimal fractions from the number.
					// Integer.toString((int)cell.getNumericCellValue()): This is converting the int
					// value to its String representation. For instance, if the cell value was
					// 12.34, after all the conversions, you'd get the string "12".
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;
				// BOOLEAN: Represents a boolean data type.
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}

		}
		// return type should be 2d array, so the method must be public Object [][]
		return data;
	}

}
