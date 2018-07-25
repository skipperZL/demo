package com.zl.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.zl.demo.exportdatadic2word.DBTable;
import com.zl.demo.exportdatadic2word.DataDic2Word;
import com.zl.demo.exportdatadic2word.WordData;

public class DB {

	// get Connection
	public Connection getConn() {
		
		String rootPath = null;
		String url = null;
		String driver = null;
		String user = null;
		String password = null;
		Connection con = null;
		Properties p = new Properties();
		rootPath = System.getProperty("user.dir");	
		Properties props =new Properties();
		
		// 参数设定
		try {
			p.load(new FileInputStream(rootPath +"/config/JDBC.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("配置文件不存在...");
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
		url = p.getProperty("url");
		driver = p.getProperty("driver");
		user = p.getProperty("user");
		password = p.getProperty("password");
		props.setProperty("user", user);
		props.setProperty("password", password);
		props.setProperty("remarks", "true"); // set remarks true

		// 加载驱动
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			System.out.println("无法找到驱动...");
			e1.printStackTrace();

		}
		// 获取连接
		try {
			con = DriverManager.getConnection(url, props);
			System.out.println("数据库连接成功!");
		} catch (SQLException e) {
			System.out.println("数据库连接失败...");
			e.printStackTrace();

		}

		return con;
	}
	
	public DBTable generateModel(Connection conns, String tableName) {
		PreparedStatement psts = null;
		DatabaseMetaData dbmd = null;
		ResultSet resultSet = null;
		DBTable table = new DBTable();
		table.setTableName(tableName);
		try {
			String sql = "select * from " + tableName;
			psts = conns.prepareStatement(sql);
			dbmd = conns.getMetaData();
			resultSet = dbmd.getTables(null, getSchema(conns), tableName.toUpperCase(), new String[] { "TABLE" });
			while (resultSet.next()) {
		    	String tableName1=resultSet.getString("TABLE_NAME");	
		    	if(tableName1.equalsIgnoreCase(tableName)){
		    		ResultSet rs = conns.getMetaData().getColumns(null, getSchema(conns),tableName.toUpperCase(), "%");
		    		while(rs.next()){	 
		    			table.getFields().add(rs.getString("COLUMN_NAME"));
		    			table.getTypes().add(rs.getString("TYPE_NAME"));
		    			table.getComments().add(rs.getString("REMARKS"));
//		    			System.out.println("列：" + rs.getString("COLUMN_NAME"));
//		    			System.out.println("类型：" + rs.getString("TYPE_NAME"));
//		    			System.out.println("注释：" + rs.getString("REMARKS"));	  
		    			//System.out.println("类型：" + rs.getString("TYPE_NAME"));
		    		}
		    		rs.close();
		    	}
		    }
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close(conns, psts, resultSet);
			
		}
		return table;
	}	
	
	/**
	 * close方法
	 * @param conn  Connection
	 * @param pst PreparedStatement
	 * @param rs ResultSet
	 */
	private void close(Connection conn, PreparedStatement pst, ResultSet rs) {
	
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		if (pst != null) {
			try {
				pst.close();
				pst = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
	}
	
	/**
	 * Close 
	 * @param conn Connection
	 * @param pst PreparedStatement
	 */
	private void close(Connection conn, PreparedStatement pst) {
	
		if (pst != null) {
			try {
				pst.close();
				pst = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
	}
	
	/**
	 * 查询当前用户所有表
	 * @param conns Connection
	 * @return WordData 生成doc文档需要数据
	 */
	public WordData queryWordDataList(Connection conns) {
		PreparedStatement psts = null;
		DatabaseMetaData dbmd = null;
		ResultSet resultSet = null;
		WordData word = new WordData();
		List<DBTable> tables = new ArrayList<>();
		
		try {
			dbmd = conns.getMetaData();
			word.setName(getFileName());
			resultSet = dbmd.getTables(null, getSchema(conns), null, new String[] { "TABLE" });
			while (resultSet.next()) {
				String tableName1 = resultSet.getString("TABLE_NAME");
				ResultSet rs = conns.getMetaData().getColumns(null, getSchema(conns), tableName1.toUpperCase(), "%");
				DBTable table = new DBTable();
				ResultSet pkrs = conns.getMetaData().getPrimaryKeys(null, getSchema(conns), tableName1.toUpperCase());
				table.setTableName(tableName1);
				List<String> pks = new ArrayList<>();
				while(pkrs.next()) {
					pks.add(pkrs.getString("COLUMN_NAME"));
				}
				pkrs.close();
				while (rs.next()) {
					table.getFields().add(rs.getString("COLUMN_NAME"));
					table.getTypes().add(rs.getString("TYPE_NAME"));
					table.getComments().add(rs.getString("REMARKS"));
					table.getFieldsLen().add(rs.getInt("COLUMN_SIZE") + "");
					table.getDigits().add(rs.getInt("DECIMAL_DIGITS") + "");
					table.getDefaultValues().add(rs.getString("COLUMN_DEF"));
					table.getIsNulls().add(rs.getString("IS_NULLABLE"));
					if (pks.contains(rs.getString("COLUMN_NAME"))) {
						table.getPks().add("YES");
					} else {
						table.getPks().add("");
					}
				}
				tables.add(table);
				rs.close();
			}
			word.setTables(tables);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conns, psts, resultSet);
		}
		return word;
	}	
	
	
	//其他数据库不需要这个方法 oracle和db2需要
	private static String getSchema(Connection conn) throws Exception {
		String schema;
		schema = conn.getMetaData().getUserName();
		if ((schema == null) || (schema.length() == 0)) {
			throw new Exception("ORACLE数据库模式不允许为空");
		}
		return schema.toUpperCase().toString();

	}	
	
	public String getFileName() {
		Properties p = new Properties();
		String rootPath = System.getProperty("user.dir");
		// 参数设定
		try {
			p.load(new FileInputStream(rootPath +"/config/JDBC.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("配置文件不存在...");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String result = p.getProperty("filename");
		return result == null ? (System.currentTimeMillis() + "") : result;
	}
	
}
