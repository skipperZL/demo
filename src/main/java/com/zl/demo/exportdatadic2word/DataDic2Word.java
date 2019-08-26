package com.zl.demo.exportdatadic2word;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

public class DataDic2Word {
	public static final int TABLE_COLUMN_NUM = 8;
	
	public void list2Word(String path, List<WordData> words) {
		for (WordData word : words) {
			dataDic2Word(path, word);
		}
	}
	
	public void dataDic2Word(String path, WordData word) {
		//Blank Document
        XWPFDocument document = null;
        //Write the Document in file system
        FileOutputStream out = null;

		try {
			document = new XWPFDocument();
			out = new FileOutputStream(new File(path + "/" + word.getName() + ".docx"));
	        //添加标题
	        XWPFParagraph titleParagraph = document.createParagraph();
	        //设置段落居中
	        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
	 
	        XWPFRun titleParagraphRun = titleParagraph.createRun();
	        titleParagraphRun.setText("数据字典\r");
	        titleParagraphRun.setColor("000000");
	        titleParagraphRun.setFontSize(20);
	 
	        Font font = new Font(-1, null, null, true, false);
	        // create table
	        for (DBTable table : word.getTables()) {
		        XWPFTable comTable = document.createTable();
		        //列宽自动分割
		        CTTblWidth comTableWidth = comTable.getCTTbl().addNewTblPr().addNewTblW();
		        comTableWidth.setType(STTblWidth.DXA);
		        comTableWidth.setW(BigInteger.valueOf(9072));
	        	//表格第一行 表名
		        XWPFTableRow comTableRowOne = comTable.getRow(0);
		        comTableRowOne.getCell(0).setText(table.getTableName());
		        for (int x = 0; x < TABLE_COLUMN_NUM - 1; x++) {
		        	comTableRowOne.addNewTableCell().setText("");
		        	comTableRowOne.getCell(x).setColor("C7B571");
		        }
		        
		        // 第二行 表头字段说明
		        XWPFTableRow comTableRowTwo = comTable.createRow();
		        int curColumnNum = 0;
		        setCellText(comTableRowTwo.getCell(curColumnNum++), "Field", font);
		        setCellText(comTableRowTwo.getCell(curColumnNum++), "Type", font);
		        setCellText(comTableRowTwo.getCell(curColumnNum++), "Size", font);
		        setCellText(comTableRowTwo.getCell(curColumnNum++), "Digit", font);
		        setCellText(comTableRowTwo.getCell(curColumnNum++), "PK", font);
		        setCellText(comTableRowTwo.getCell(curColumnNum++), "isNull", font);
		        setCellText(comTableRowTwo.getCell(curColumnNum++), "Default", font);
		        setCellText(comTableRowTwo.getCell(curColumnNum++), "Comment", font);
		        
		        setCellWidth(comTableRowTwo.getCell(2), 800l);
		        setCellWidth(comTableRowTwo.getCell(3), 800l);
		        setCellWidth(comTableRowTwo.getCell(4), 800l);
		        setCellWidth(comTableRowTwo.getCell(5), 800l);
		        
		        int count = table.getFields().size();
		        for (int i = 0; i < count; i++) {
			        XWPFTableRow row = comTable.createRow();
			        curColumnNum = 0;
			        row.getCell(curColumnNum++).setText(table.getFields().get(i));
			        row.getCell(curColumnNum++).setText(table.getTypes().get(i));
			        row.getCell(curColumnNum++).setText(table.getFieldsLen().get(i));
			        row.getCell(curColumnNum++).setText(table.getDigits().get(i));
			        row.getCell(curColumnNum++).setText(table.getPks().get(i));
			        row.getCell(curColumnNum++).setText(table.getIsNulls().get(i));
			        row.getCell(curColumnNum++).setText(table.getDefaultValues().get(i));
			        row.getCell(curColumnNum++).setText(table.getComments().get(i));

			        setCellWidth(row.getCell(2), 800l);
			        setCellWidth(row.getCell(3), 800l);
			        setCellWidth(row.getCell(4), 800l);
			        setCellWidth(row.getCell(5), 800l);
		        }
		        
		        //两个表格之间加个换行
		        XWPFParagraph paragraph = document.createParagraph();
		        XWPFRun paragraphRun = paragraph.createRun();
		        paragraphRun.setText("\r");
		        mergeCellsHorizonal(comTable, 0, 0, TABLE_COLUMN_NUM - 1);
	        }
	 
	        document.write(out);
	        System.out.println("Success.");
		} catch(IOException e) {
			System.out.println("IOException!");
			System.out.println(e);
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (document != null)
					document.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
    /**
     * Merge Column 
     * @param table
     * @param row 
     * @param fromCell
     * @param toCell
     */
	public static void mergeCellsHorizonal(XWPFTable table, int row, int fromCol, int toCol) {
		if (toCol <= fromCol)
			return;
		XWPFTableCell cell = table.getRow(row).getCell(fromCol);
		CTTcPr tcPr = getTcPr(cell);
		XWPFTableRow rowTable = table.getRow(row);
		for (int colIndex = toCol; colIndex > fromCol; colIndex--) {
			rowTable.getCtRow().removeTc(colIndex);
			rowTable.removeCell(colIndex);
		}
		tcPr.addNewGridSpan();
		tcPr.getGridSpan().setVal(BigInteger.valueOf(toCol - fromCol + 1));
	}
    
    private static CTTcPr getTcPr(XWPFTableCell cell) {
        CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr()
                : cell.getCTTc().addNewTcPr();
        return tcPr;
    }
    
/*    private static void setColor(XWPFTableCell cell, String shdColor) {
		CTTc cttc = cell.getCTTc();
		CTTcPr ctPr = cttc.isSetTcPr() ? cttc.getTcPr() : cttc.addNewTcPr();
		CTShd ctshd = ctPr.isSetShd() ? ctPr.getShd() : ctPr.addNewShd();
		// ctshd.setColor(shdColor);
		// ctshd.setFill(shdColor);
		cell.setColor(shdColor);
    }*/
    
    private static void setCellText(XWPFTableCell cell, String text, Font font) {
    	// remove stuff
    	cell.removeParagraph(0);
        XWPFParagraph paragraph = cell.addParagraph();
        setRun(paragraph.createRun() , text, font);
    }
    
    /**
     * set cell width
     * @param cell  The cell 
     * @param width the width that you need!
     */
    private static void setCellWidth(XWPFTableCell cell, long width) {
		CTTc cttc = cell.getCTTc();
		CTTcPr ctPr = cttc.isSetTcPr() ? cttc.getTcPr() : cttc.addNewTcPr();
		ctPr.addNewTcW().setW(BigInteger.valueOf(width));
    }
    
    private static void setRun(XWPFRun run, String text, Font font) {
    	setRun(run, font.fontFamily, font.fontSize, font.colorRGB, text, font.bold, font.addBreak);
    }
    
	private static void setRun(XWPFRun run, String fontFamily, int fontSize, String colorRGB, String text, boolean bold,
			boolean addBreak) {
		if (fontFamily != null)
			run.setFontFamily(fontFamily);
		if (fontSize > 0)
			run.setFontSize(fontSize);
		if (colorRGB != null)
			run.setColor(colorRGB);
		run.setText(text);
		run.setBold(bold);
		if (addBreak)
			run.addBreak();
	}
	
	private static class Font{
		int fontSize;
		String fontFamily;
		String colorRGB;
		boolean bold;
		boolean addBreak;
		
		public Font(int fontSize, String fontFamily, String colorRGB, boolean bold, boolean addBreak) {
			this.fontSize = fontSize;
			this.fontFamily = fontFamily;
			this.colorRGB = colorRGB;
			this.bold = bold;
			this.addBreak = addBreak;
		}
		
	}
	
}
