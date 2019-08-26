package com.zl.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

public class POIUtilsMerge {
	
	public static void merge(String excelName) {		
		HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel
		// excel生成过程: excel-->sheet-->row-->cell
		HSSFSheet sheet = workbook.createSheet("test"); // 为excel创建一个名为test的sheet页
		HSSFRow row = sheet.createRow(1); // 创建一行,参数2表示第一行
		HSSFCell cellB2 = row.createCell(1); // 在B2位置创建一个单元格
		HSSFCell cellB3 = row.createCell(2); // 在B3位置创建一个单元格
		cellB2.setCellValue("单元格B2"); // B2单元格填充内容
		cellB3.setCellValue("单元格B3"); // B3单元格填充内容

		HSSFCellStyle cellStyle = workbook.createCellStyle(); // 单元格样式
		Font fontStyle = workbook.createFont(); // 字体样式
		fontStyle.setBold(true); // 加粗
		fontStyle.setFontName("黑体"); // 字体
		fontStyle.setFontHeightInPoints((short) 11); // 大小
		// 将字体样式添加到单元格样式中
		cellStyle.setFont(fontStyle);
		// 边框，居中
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellB2.setCellStyle(cellStyle); // 为B2单元格添加样式

		// 合并单元格
		CellRangeAddress cra = new CellRangeAddress(1, 3, 1, 1); // 起始行, 终止行, 起始列, 终止列
		sheet.addMergedRegion(cra);
		cellB2.setCellValue("Update!");

		// 使用RegionUtil类为合并后的单元格添加边框
		RegionUtil.setBorderBottom(1, cra, sheet); // 下边框
		RegionUtil.setBorderLeft(1, cra, sheet); // 左边框
		RegionUtil.setBorderRight(1, cra, sheet); // 有边框
		RegionUtil.setBorderTop(1, cra, sheet); // 上边框

		FileOutputStream out = null;
		try {
			out = new FileOutputStream(excelName);
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			out = null;
		}
	}
	
	public static void readMerge(String excelName) throws FileNotFoundException, IOException {
		List<List<String>> result = new ArrayList<>();
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(excelName)));
		HSSFSheet sheet = null;
		//workbook.getNumberOfSheets()
		//workbook.getSheetAt(i)
		sheet = workbook.getSheetAt(0);
		for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {
			HSSFRow row = sheet.getRow(j);
			List<String> rowData = new ArrayList<>();
			addColumnData(sheet, rowData, row, null);
			result.add(rowData);
			System.out.println();
		}
		System.out.println("Read sheet：" + workbook.getSheetName(0) + " finished!");
	}
	
	private static void addColumnData(HSSFSheet sheet, List<String> rowData, Row row, List<Integer> columns) {
		if (row != null) {
			if (columns == null || columns.size() == 0) {
				for (int k = 0; k < row.getLastCellNum(); k++) {
					rowData.add(doCellValue(sheet, row.getRowNum(), k));
					System.out.print(k + ":" + doCellValue(sheet, row.getRowNum(), k) + "	");
				}
			} else {
				for (int k : columns) {
					rowData.add(row.getCell(k) == null ? "" : row.getCell(k).toString().trim());
				}
			}
		}
	}
	
	private static String doCellValue(HSSFSheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress range = sheet.getMergedRegion(i);
			int firstColumn = range.getFirstColumn();
			int lastColumn = range.getLastColumn();
			int firstRow = range.getFirstRow();
			int lastRow = range.getLastRow();
			if (row >= firstRow && row <= lastRow) {
				if (column >= firstColumn && column <= lastColumn) {
					return doCellValueForNull(sheet, firstRow, firstColumn);
				}
			}
		}
		return doCellValueForNull(sheet, row, column);
	}
	
	private static String doCellValueForNull(HSSFSheet sheet, int row, int column) {
		if (sheet.getRow(row) == null)
			return "";
		if (sheet.getRow(row).getCell(column) == null)
			return "";
		if (sheet.getRow(row).getCell(column) == null)
			return "";
		return sheet.getRow(row).getCell(column).toString();
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String excelName = "D://myExcel.xls";
		//merge(excelName);
		readMerge(excelName);
	}

}