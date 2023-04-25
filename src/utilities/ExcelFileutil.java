package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileutil {
	XSSFWorkbook wb;

	//constructor for reading ecxel path

	public ExcelFileutil(String ExcelFile)throws Throwable

	{

	FileInputStream fi = new FileInputStream(ExcelFile);

	wb = new XSSFWorkbook(fi);

	}

	//method for counting no of rows in sheet

	public int rowCount(String sheetName)

	{

	return wb.getSheet(sheetName).getLastRowNum();

	}

	//method for reading cell data

	public String getCellData(String sheetname,int row,int column)

	{

	String data="";

	if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)

	{

	int celldata =(int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();

	data =String.valueOf(celldata);

	}

	else

	{

	data =wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();

	}

	return data;

	}

	//method for setcelldata

	public void setCelldata(String sheetName,int row,int column,String status,String WriteExcel)throws Throwable

	{

	//get sheet from wb

	XSSFSheet ws = wb.getSheet(sheetName);

	//get row from sheet

	XSSFRow rowNum =ws.getRow(row);

	//create cell

	XSSFCell cell =rowNum.createCell(column);

	cell.setCellValue(status);

	if(status.equalsIgnoreCase("Pass"))

	{

	XSSFCellStyle style = wb.createCellStyle();

	XSSFFont font = wb.createFont();

	font.setColor(IndexedColors.GREEN.getIndex());

	font.setBold(true);

	font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);

	style.setFont(font);

	rowNum.getCell(column).setCellStyle(style);

	}

	else if(status.equalsIgnoreCase("Fail"))

	{

	XSSFCellStyle style = wb.createCellStyle();

	XSSFFont font = wb.createFont();

	font.setColor(IndexedColors.RED.getIndex());

	font.setBold(true);

	font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);

	style.setFont(font);

	rowNum.getCell(column).setCellStyle(style);

	}

	else if(status.equalsIgnoreCase("Blocked"))

	{

	XSSFCellStyle style = wb.createCellStyle();

	XSSFFont font = wb.createFont();

	font.setColor(IndexedColors.BLUE.getIndex());

	font.setBold(true);

	font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);

	style.setFont(font);

	rowNum.getCell(column).setCellStyle(style);

	}

	FileOutputStream fo = new FileOutputStream(WriteExcel);

	wb.write(fo);

	}

	}

























