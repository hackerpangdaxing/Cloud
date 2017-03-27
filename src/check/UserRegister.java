package check;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.User;
import util.DbUtil;

public class UserRegister {
	 private  DbUtil dbUtil = new DbUtil();
	
	public  int addUserRegister(User user)throws Exception{
		Connection con = dbUtil.getCloudClassCon();
		String sql = "insert into user values(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPwd());
		int result = pstmt.executeUpdate();
		
		dbUtil.close(pstmt, con);
		return result;

	}
	
	/*public static void main(String[] args) throws Exception{
		User user = new User("sturoot1","123");
		int result=addUserRegister(user);
		if(result==1){
			System.out.println("注册成功！");
		}else{
			System.out.println("注册失败");
		}
	}*/
  
}
