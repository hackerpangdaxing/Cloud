package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;


/**
 *DbUtil.java
 *util
 * @author 胖大星
 *@date 2016年11月2日上午10:12:16
 */
public class DbUtil {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/";
	private static final String dbUserName = "root";
	private static final String dbPassword = "529529";
	private static final String jdbcName = "com.mysql.jdbc.Driver";

	public Connection getProblemCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName,dbPassword);
		return con;

	}
	
	public Connection getProblemCon(String ProblemID)throws Exception{
		String ProblemDB = getProblemIDName(ProblemID);
		String Problem_DB_URL = dbUrl+ProblemDB;
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(Problem_DB_URL, dbUserName, dbPassword);		
		return con;
	}

	private String getProblemIDName(String problemID) {
		
		
		return null;
	}
	
	
	public Connection getCloudClassCon()throws Exception{
		String CloudClassDB_Url = dbUrl+"cloudclass"+"?useUnicode=true&characterEncoding=UTF-8";  
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(CloudClassDB_Url, dbUserName, dbPassword);
		return con;
	}

	public void close(PreparedStatement pstmt, Connection con) throws Exception {

		if (pstmt != null) {
			pstmt.close();
			if (con != null) {
				con.close();
			}
		}
	}
	public void close1(Statement stmt, Connection con) throws Exception {

		if (stmt != null) {
			stmt.close();
			if (con != null) {
				con.close();
			}
		}
	}


}
