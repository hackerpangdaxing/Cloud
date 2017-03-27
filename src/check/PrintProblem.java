package check;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DbUtil;

public class PrintProblem {
	private DbUtil dbUtil = new DbUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "select * from user where id=?";
	

}
