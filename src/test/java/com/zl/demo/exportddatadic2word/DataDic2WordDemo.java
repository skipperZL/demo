package com.zl.demo.exportddatadic2word;

import com.zl.demo.exportdatadic2word.DataDic2Word;
import com.zl.demo.exportdatadic2word.WordData;
import com.zl.utils.DB;

public class DataDic2WordDemo {

	public static void main(String[] args) {
		DB db = new DB(); 
		WordData word = db.queryWordDataList(db.getConn());
		DataDic2Word dw =  new DataDic2Word();
		String out = "/home/zl/Documents";
		String winOut = "D://";
		dw.dataDic2Word(winOut, word);
	}
}
