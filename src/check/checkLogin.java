package check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.DbUtil;

public class checkLogin {

	    DbUtil dbUtil = new DbUtil();
	public int checklogin(User model) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int flag =-1;
		//System.out.println("hello1");
		try {
			//System.out.println("hello2");
			// 连接
			connection = dbUtil.getCloudClassCon();
			// SQL语句
			String sql = "select * from user where userName = ? and userPwd =? ";
			// 创建Statement对象
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, model.getUserName());
			pstmt.setString(2, model.getUserPwd());
			// 执行
			rs = pstmt.executeQuery();
			// 判断数据库是否为空
			if (rs != null && rs.next()) {
				flag = 1;
				System.out.println("hello");
				rs.close();
				pstmt.close();
			}else{
				flag = 0;
				rs.close();
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		dbUtil.close(pstmt, connection);
		System.out.println(flag);
		return flag;
	}


	
	
/*   public static void main(String args []) throws Exception{
	   User user = new User("root","123");
	   checkLogin check = new checkLogin();
	   boolean flag = check.checklogin(user);
	   System.out.println(flag);
   } */
}
