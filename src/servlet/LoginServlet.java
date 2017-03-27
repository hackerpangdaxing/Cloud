package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.session.SessionListener;

import bean.UserTest;
import check.UserRegister;
import check.checkLogin;
import dao.IUserDao;
import dao.UserDaoImpl;
import model.User;
import model.UserList;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset =utf-8");
		// 获取注册表单的用户名以及密码
		
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("password");

		
		PrintWriter pw = response.getWriter();
		User user = new User(userName,userPwd);
		checkLogin check = new checkLogin();

 
		try {

			if (check.checklogin(user) ==1) {
				
				request.getSession().setAttribute("userName", userName);
				//如果不存在session会话，就创建一个session对象
				HttpSession session = request.getSession();
				
				/**
				 * 这里的session还有问题，解决多用户登入将session过期时间设置为5分钟,还没有解决用户退出问题
				 * */
				
				SessionListener c = new SessionListener();
				
				session.setAttribute("userName", userName);   //将账号放入session中
				
				//防止多用户同时登入同一个账号
				if(c.isAlreadyEnter(session, userName)){
					pw.write("该用户已经登入过，请换个号码重试！");
					System.out.println("该用户已经登入过，请换个号码重试！");
		  
				}else{
					response.sendRedirect(request.getContextPath() +"/TestOnline.html");  
				System.out.println("登入成功！");
				}
				
		
			} else {
				pw.write("密码错误");
				System.out.println("密码错误");
			}
		} catch (Exception e) {

			e.printStackTrace();
			pw.write("登入出现异常！");
			System.out.println("登入出现异常！");
		}


	}

}
