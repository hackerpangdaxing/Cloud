package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DbUtil;
import model.User;

public class UserDaoImpl implements IUserDao {
    /**
    * 用户增加
     * @throws Exception 
    */
	 boolean flag = false;
	  Connection connection = null;
      PreparedStatement pstmt = null;
      DbUtil dbUtil = new DbUtil();
    public boolean insertUser(User model) throws Exception {

        try {
            // 连接
        	connection = dbUtil.getCloudClassCon();

            // SQL语句
            String sql = " insert into user vlaues (null,?,?)";

            // 创建Statement对象
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, model.getUserName());
            pstmt.setString(2, model.getUserPwd());

            // 执行
            int result = pstmt.executeUpdate();
            System.out.println("受影响的行数" + result);
            flag = true;

        } catch (Exception e) {
            flag = false;
             e.printStackTrace();
        } finally {
            // 关闭
            dbUtil.close(pstmt, connection);
        }

        return flag;
    }


    public boolean deleteUser(String userName) throws Exception {


        try {
            // 连接
            connection =   dbUtil.getCloudClassCon();

            // SQL语句
            String sql = "DELETE FROM user WHERE userName = ? ";

            // 创建Statement对象
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, userName);

            // 执行
            int result = pstmt.executeUpdate();
            System.out.println("受影响的行数" + result);
            flag = true;

        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        } finally {
            // 关闭
           dbUtil.close(pstmt, connection);
        }

        return flag;
    }

    /**
    * 用户修改
     * @throws Exception 
    */
    public boolean updateUser(User model) throws Exception {
 

        try {
            // 连接
        	 connection =   dbUtil.getCloudClassCon();

            // SQL语句
            String sql = "UPDATE  user SET  userPwd = ?  WHERE userName = ? ";

            // 创建Statement对象
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, model.getUserName());
            pstmt.setString(2, model.getUserPwd());

            System.err.println(pstmt);

            // 执行
            int result = pstmt.executeUpdate();
            System.out.println("受影响的行数" + result);
            flag = true;
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        } finally {
            // 关闭
        	 connection =   dbUtil.getCloudClassCon();
        }

        return flag;
    }

    /**
    * 用户查询（所有）
     * @throws Exception 
    */
    public List<User> findAll() throws Exception {
        List<User> list = new ArrayList<User>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 连接
        	 connection =   dbUtil.getCloudClassCon();

            // SQL语句
            String sql = "SELECT * FROM user";

            // 创建Statement对象
            pstmt = connection.prepareStatement(sql);

            // 执行
            rs = pstmt.executeQuery();
            // 游标向下移动一行
            while (rs.next()) {
                User model = new User();
                model.setUserName(rs.getString("username"));
                model.setUserPwd(rs.getString("password"));
                // 添加到集合
                list.add(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(pstmt, connection);
        }

        return list;
    }

    /**
    * 用户查询（根据条件）
     * @throws Exception 
    */
    public  boolean findByTerm(User model) throws Exception {
        boolean flag = false;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 连接
        	 connection =   dbUtil.getCloudClassCon();

            // SQL语句
            String sql = "SELECT *  FROM user WHERE userName=? AND  userPwd= ? ";

            // 创建Statement对象
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, model.getUserName());
            pstmt.setString(2, model.getUserPwd());

            // 执行
            rs = pstmt.executeQuery();

            // 判断数据库是否为空
            if (rs != null && rs.next()) {
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭
            dbUtil.close(pstmt, connection);
        }

        return flag;
    }




}
