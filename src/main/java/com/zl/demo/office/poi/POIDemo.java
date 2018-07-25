package com.zl.demo.office.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

public class POIDemo {

	public static void main(String[] args) throws IOException {

        //Blank Document
        XWPFDocument document= new XWPFDocument();
 
        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("D://word_template.docx"));
        
 
        //添加标题
        XWPFParagraph titleParagraph = document.createParagraph();
        //设置段落居中
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
 
        XWPFRun titleParagraphRun = titleParagraph.createRun();
        titleParagraphRun.setText("Word Title");
        titleParagraphRun.setColor("000000");
        titleParagraphRun.setFontSize(20);
        titleParagraphRun.setFontFamily("仿宋");
 
        
        //段落
        XWPFParagraph firstParagraph = document.createParagraph();
        XWPFRun run = firstParagraph.createRun();
        run.setText("This is a graph!");
        run.setColor("696969");
        run.setFontSize(16);
 
        //设置段落背景颜色
        CTShd cTShd = run.getCTR().addNewRPr().addNewShd();
        cTShd.setVal(STShd.CLEAR);
        cTShd.setFill("97FFFF");
 
 
        //换行
        XWPFParagraph paragraph1 = document.createParagraph();
        XWPFRun paragraphRun1 = paragraph1.createRun();
        paragraphRun1.setText("\r");
 
 
        //基本信息表格
        XWPFTable infoTable = document.createTable();
        //去表格边框
        infoTable.getCTTbl().getTblPr().unsetTblBorders();
 
 
        //列宽自动分割
        CTTblWidth infoTableWidth = infoTable.getCTTbl().addNewTblPr().addNewTblW();
        infoTableWidth.setType(STTblWidth.DXA);
        infoTableWidth.setW(BigInteger.valueOf(9072));
 
 
        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("name");
        infoTableRowOne.addNewTableCell().setText(": Lucy");
 
        //表格第二行
        XWPFTableRow infoTableRowTwo = infoTable.createRow();
        infoTableRowTwo.getCell(0).setText("age");
        infoTableRowTwo.getCell(1).setText(": 11");
 
        //表格第三行
        XWPFTableRow infoTableRowThree = infoTable.createRow();
        infoTableRowThree.getCell(0).setText("sex");
        infoTableRowThree.getCell(1).setText(": female");
 
        //表格第四行
        XWPFTableRow infoTableRowFour = infoTable.createRow();
        infoTableRowFour.getCell(0).setText("country");
        infoTableRowFour.getCell(1).setText(": US");
 
 
 
        //两个表格之间加个换行
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun paragraphRun = paragraph.createRun();
        paragraphRun.setText("\r");
 
 
 
        //工作经历表格
        XWPFTable ComTable = document.createTable();
 
 
        //列宽自动分割
        CTTblWidth comTableWidth = ComTable.getCTTbl().addNewTblPr().addNewTblW();
        comTableWidth.setType(STTblWidth.DXA);
        comTableWidth.setW(BigInteger.valueOf(9072));
 
        //表格第一行
        XWPFTableRow comTableRowOne = ComTable.getRow(0);
        comTableRowOne.getCell(0).setText("CPU");
        comTableRowOne.addNewTableCell().setText("GREEN");
        comTableRowOne.addNewTableCell().setText("COLOR");
        comTableRowOne.addNewTableCell().setText("NAME");
 
        //表格第二行
        XWPFTableRow comTableRowTwo = ComTable.createRow();
        comTableRowTwo.getCell(0).setText("i5 8400");
        comTableRowTwo.getCell(1).setText("normal");
        comTableRowTwo.getCell(2).setText("black");
        //comTableRowTwo.getCell(3).setText("shenzhou");
        setCellText(comTableRowTwo.getCell(3), "朋友", new Font(-1, "宋体", "FF0000", true, false));
 
        //表格第三行
        XWPFTableRow comTableRowThree = ComTable.createRow();
        comTableRowThree.getCell(0).setText("i5 8400");
        comTableRowThree.getCell(1).setText("perfect");
        comTableRowThree.getCell(2).setText("grey");
        comTableRowThree.getCell(3).setText("shenzhou");
        // 设置cell背景色
        comTableRowThree.getCell(3).setColor("FF0000");
 
 
        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document, sectPr);
 
        //添加页眉
        CTP ctpHeader = CTP.Factory.newInstance();
        CTR ctrHeader = ctpHeader.addNewR();
        CTText ctHeader = ctrHeader.addNewT();
        String headerText = "Java POI create MS word file.";
        ctHeader.setStringValue(headerText);
        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, document);
        //设置为右对齐
        headerParagraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFParagraph[] parsHeader = new XWPFParagraph[1];
        parsHeader[0] = headerParagraph;
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);
 
 
        //添加页脚
        CTP ctpFooter = CTP.Factory.newInstance();
        CTR ctrFooter = ctpFooter.addNewR();
        CTText ctFooter = ctrFooter.addNewT();
        String footerText = "This is footerText!";
        ctFooter.setStringValue(footerText);
        XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, document);
        headerParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFParagraph[] parsFooter = new XWPFParagraph[1];
        parsFooter[0] = footerParagraph;
        policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);
 
        mergeCellsHorizonal(ComTable, 0, 0, 2);
        
        document.write(out);
        out.close();
        System.out.println("create_table document written success.");

	}
	
	static void mergeCellVertically(XWPFTable table, int col, int fromRow, int toRow) {
		for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
			XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
			CTVMerge vmerge = CTVMerge.Factory.newInstance();
			if (rowIndex == fromRow) {
				// The first merged cell is set with RESTART merge value
				vmerge.setVal(STMerge.RESTART);
			} else {
				// Cells which join (merge) the first one, are set with CONTINUE
				vmerge.setVal(STMerge.CONTINUE);
				// and the content should be removed
				for (int i = cell.getParagraphs().size(); i > 0; i--) {
					cell.removeParagraph(0);
				}
				cell.addParagraph();
			}
			// Try getting the TcPr. Not simply setting an new one every time.
			CTTcPr tcPr = cell.getCTTc().getTcPr();
			if (tcPr != null) {
				tcPr.setVMerge(vmerge);
			} else {
				// only set an new TcPr if there is not one already
				tcPr = CTTcPr.Factory.newInstance();
				tcPr.setVMerge(vmerge);
				cell.getCTTc().setTcPr(tcPr);
			}
		}
	}

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
		tcPr.getGridSpan().setVal(BigInteger.valueOf((long) (toCol - fromCol + 1)));
	}
    
    private static CTTcPr getTcPr(XWPFTableCell cell) {
        CTTcPr tcPr = cell.getCTTc().isSetTcPr() ? cell.getCTTc().getTcPr()
                : cell.getCTTc().addNewTcPr();
        return tcPr;
    }
    
    public void setCellText(XWPFTableCell cell, String text, int width,  
            boolean isShd, int shdValue, String shdColor) {  
        CTTc cttc = cell.getCTTc();  
        CTTcPr ctPr = cttc.isSetTcPr() ? cttc.getTcPr() : cttc.addNewTcPr();  
        CTShd ctshd = ctPr.isSetShd() ? ctPr.getShd() : ctPr.addNewShd();  
        ctPr.addNewTcW().setW(BigInteger.valueOf(width));  
        if (isShd) {  
            if (shdValue > 0 && shdValue <= 38) {  
                ctshd.setVal(STShd.Enum.forInt(shdValue));  
            }  
            if (shdColor != null) {  
                // ctshd.setFill(shdColor);  
                // ctshd.setColor("auto");  
                ctshd.setColor(shdColor);  
            }  
        }  
  
        ctPr.addNewVAlign().setVal(STVerticalJc.CENTER);  
        cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);  
        cell.setText(text);  
    }
    
    private static void setCellText(XWPFTableCell cell, String text, Font font) {
    	// remove stuff
    	cell.removeParagraph(0);
        XWPFParagraph paragraph = cell.addParagraph();
        setRun(paragraph.createRun() , text, font);
    }
    
    private static void setRun(XWPFRun run, String text, Font font) {
    	setRun(run, font.fontFamily, font.fontSize, font.colorRGB, text, font.bold, font.addBreak);
    }
    
	private static void setRun(XWPFRun run, String fontFamily, int fontSize, String colorRGB, String text, boolean bold,
			boolean addBreak) {
		run.setFontFamily(fontFamily);
		if (fontSize > 0)
			run.setFontSize(fontSize);
		run.setColor(colorRGB);
		run.setText(text);
		run.setBold(bold);
		  //设置段落背景颜色
//        CTShd cTShd = run.getCTR().addNewRPr().addNewShd();
//        cTShd.setVal(STShd.CLEAR);
//        cTShd.setFill("97FFFF");
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
