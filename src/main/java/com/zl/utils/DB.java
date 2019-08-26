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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
					try {
						table.getDefaultValues().add(rs.getString("COLUMN_DEF"));
					} catch (Exception e) {
						e.printStackTrace();
						table.getDefaultValues().add("");
					}
					
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
		String user = getExportUser();
		if (user != null && !"".equals(user)) {
			return user;
		}
		String schema;
		schema = conn.getMetaData().getUserName();
		
		if ((schema == null) || (schema.length() == 0)) {
			throw new Exception("ORACLE数据库模式不允许为空");
		}
		if ("SQLSERVER".equals(getDBType()))
			return null;
		return schema.toUpperCase().toString();

	}	
	
	public String getFileName() {
		String result = getValueFromPro("filename");
		return result == null ? (System.currentTimeMillis() + "") : result;
	}
	
	public static String getExportUser() {
		String result = getValueFromPro("exportuser");
		return result;
	}
	
	public static String getDBType() {
		String result = getValueFromPro("driver");
		if (result.indexOf("sqlserver") > -1) {
			return "SQLSERVER";
		} else if (result.indexOf("mysql") > -1) {
			return "MYSQL";
		} else if (result.indexOf("oracle") > -1) {
			return "ORACLE";
		} else {
			return result;
		}
		
	}
	
	public static String getValueFromPro(String key) {
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
		String result = p.getProperty(key);
		return result;
	}
	
	/**
	 * Query Demo
	 * @return  list
	 */
	public List<Object> Query() {
		PreparedStatement psts = null;
		Connection conns = getConn();
		ResultSet rss = null;
		List list = new ArrayList();
		try {
			String sqls = "select * from test";
			psts = conns.prepareStatement(sqls);
			rss = psts.executeQuery();
			while (rss.next()) {
				Timestamp punchtime = rss.getTimestamp("punchtime");
				int sId = rss.getInt("id");
				String userName = rss.getString("username");
				list.add(userName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conns, psts, rss);
		}

		return list;
	}

   /**
	 * 
	 * @param list
	 * @return
	 */
	public boolean insert(List list) {
		Connection conn = null;
		PreparedStatement pst = null;
		Connection conns = null;
		PreparedStatement psts = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "";
		String sqls = "";
		try {
			conn = getConn();
			conn.setAutoCommit(false);
			sql = "insert into test (date1,field2,field3,field4,field5,field6) values (to_date(?,'yyyy-MM-dd'),?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			conns = getConn();
			conns.setAutoCommit(false);
			sqls = "update dbo.attrecord set verify = 9 where id = ?";
			psts = conns.prepareStatement(sqls);
			for (int i = 0; i < list.size(); i++) {
				Object obj = list.get(i);
				pst.setString(1, "");
				pst.setString(2, "");
				pst.setString(3, "");
				pst.setString(4, "");
				pst.setString(5, "");
				pst.setString(6, "");
				pst.addBatch();
				psts.setInt(1, 1);
				psts.addBatch();
			}
			pst.executeBatch();
			psts.executeBatch();
			conn.commit();
			conns.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				conns.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conns.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(conn, pst);
			close(conns, psts);
		}

		return true;
	}

}
