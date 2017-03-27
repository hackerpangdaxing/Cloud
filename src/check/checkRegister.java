package check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;

import util.DbUtil;
import model.User;

public class checkRegister {

	DbUtil dbUtil = new DbUtil();

	public int IsExit(User user) {
		int flag = -1;
		Connection conn = null;
		Statement stmt =null;
		try {
			conn = dbUtil.getCloudClassCon();
			String sql = " select * from user where userName = '"+user.getUserName()+"'";
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("该账号已经存在！");
				//System.out.println(rs.toString());
				flag = 0;
				rs.close();
				dbUtil.close1(stmt, conn);
			} else {
				System.out.println("当前用户不存在！");
				flag = 1;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return flag;
	}

	public int save(User user) {
		int flag = -1;
		Connection conn = null;
		ResultSet rs = null;
	
		try {
			conn = dbUtil.getCloudClassCon();
			String sql = " insert into user (userName,userPwd,date) values('"
					+ user.getUserName() + "','" + user.getUserPwd() +"','"+user.getDate()+ "')";
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			 rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				System.out.println("注册数据库成功！");
				//System.out.println(rs.toString());
				flag = 1;
				rs.close();
				dbUtil.close1(stmt, conn);
			} else {
				System.out.println("注册数据库失败！");
				rs.close();
				dbUtil.close1(stmt, conn);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return flag;
	}

	/*
	 * public int IsRegister(User user){ int flag = -1; DbUtil dbUtil = null;
	 * Connection conn = null; PreparedStatement pstmt = null; ResultSet rs =
	 * null; System.out.println("hello1"); try { System.out.println("hello2");
	 * conn = dbUtil.getCloudClassCon(); // SQL语句 String sql =
	 * "select * from user where userName = ? "; // 创建Statement对象 pstmt =
	 * conn.prepareStatement(sql); pstmt.setString(1, user.getUserName()); // 执行
	 * rs = pstmt.executeQuery(); // 判断数据库是否为空 if (rs != null && rs.next()) {
	 * flag = 0; System.out.println("hello3"); rs.close(); pstmt.close(); }else{
	 * flag = 1; rs.close(); pstmt.close(); } } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return flag; }
	 */
	/*
	 * DbUtil dbUtil = new DbUtil(); public void register(User model) throws
	 * Exception { Connection connection = null; PreparedStatement pstmt = null;
	 * ResultSet rs = null; try{ String sql =
	 * "insert into user values(null,?,?)"; pstmt =
	 * connection.prepareStatement(sql); pstmt.setString(1,
	 * model.getUserName()); pstmt.setString(2, model.getUserPwd()); rs =
	 * pstmt.executeQuery(); }catch(Exception e){
	 * System.out.println("注册数据库失败！"); }finally{ dbUtil.close(pstmt,
	 * connection); } }
	 */

}
