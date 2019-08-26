package com.zl.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIUtils {
	
	/**
	 * export data from the first sheet
	 * @param path file path
	 * @param columns if columns is null, will export all columns data!
	 * @param startRow starting position
	 * @return every rows' data
	 * @throws Exception
	 */
	private static List<List<String>> showXLS(String path, List<Integer> columns, int startRow) throws Exception {
		List<List<String>> result = new ArrayList<>();
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(path)));
		HSSFSheet sheet = null;
		//workbook.getNumberOfSheets()
		//workbook.getSheetAt(i)
		sheet = workbook.getSheetAt(0);
		for (int j = startRow; j < sheet.getLastRowNum() + 1; j++) {
			HSSFRow row = sheet.getRow(j);
			List<String> rowData = new ArrayList<>();
			addColumnData(rowData, row, columns);
			result.add(rowData);
		}
		System.out.println("Read sheet：" + workbook.getSheetName(0) + " finished!");
		return result;
	}
	
	/**
	 * export data from the first sheet
	 * @param path file path
	 * @param columns if columns is null, will export all columns data!
	 * @param startRow starting position
	 * @return every rows' data
	 * @throws Exception
	 */
	private static List<List<String>> showXLSX(String path, List<Integer> columns, int startRow) throws Exception {
		List<List<String>> result = new ArrayList<>();
		InputStream is = new FileInputStream(path);
		XSSFWorkbook xwb = new XSSFWorkbook(is);
		XSSFSheet sheet = xwb.getSheetAt(0);
		XSSFRow row;
		
		for (int i = startRow; i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			List<String> rowData = new ArrayList<>();
			addColumnData(rowData, row, columns);
			result.add(rowData);
		}
		System.out.println("Read sheet：" + xwb.getSheetName(0) + " finished!");
		return result;
	}
	
	private static void addColumnData(List<String> rowData, Row row, List<Integer> columns) {
		if (row != null) {
			if (columns == null || columns.size() == 0) {
				for (int k = 0; k < row.getLastCellNum(); k++) {
					rowData.add(row.getCell(k) == null ? "" : row.getCell(k).toString().trim());
				}
			} else {
				for (int k : columns) {
					rowData.add(row.getCell(k) == null ? "" : row.getCell(k).toString().trim());
				}
			}
		}
	}
	
	/**
	 * export data from the first sheet
	 * @param path file path
	 * @param columns if columns is null, will export all columns data! The first index is 0.
	 * @param startRow starting position
	 * @return every rows' data
	 * @throws Exception
	 */
	public static List<List<String>> showExcel(String path, List<Integer> columns, int startRow) throws Exception {
		if (path == null || "".equals(path.trim())) {
			System.err.println("Path is empty!");
			return null;
		}
		String suffix = path.substring(path.lastIndexOf(".") + 1);
		if ("xls".equals(suffix)) {
			return showXLS(path, columns, startRow);
		}
		if ("xlsx".equals(suffix)) {
			return showXLSX(path, columns, startRow);
		}
		System.err.println("Unkown file type!");
		return null;
	}
	
	/**
     * export excel. xls
     * @param sheetName sheet name
     * @param title title
     * @param values 
     * @param wb HSSFWorkbook instance
     * @return HSSFWorkbook
     */
	public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[][] values, HSSFWorkbook wb) {
		// create a excel.
		if (wb == null) {
			wb = new HSSFWorkbook();
		}
		HSSFSheet sheet = wb.createSheet(sheetName);
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式

		// 声明列对象
		HSSFCell cell = null;

		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}

		// 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				// 将内容按顺序赋给对应的列对象
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		return wb;
	}
	
	public static void createXls(String path, String sheetName, String[] title, String[][] values, HSSFWorkbook workbook) {
		HSSFWorkbook wb = getHSSFWorkbook(sheetName, title, values, workbook);
		File file = new File(path);
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			wb.write(os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Wirting file error!");
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (wb != null) {
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
