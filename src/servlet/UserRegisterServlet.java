package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import check.UserRegister;
import check.checkLogin;
import check.checkRegister;
import dao.IUserDao;
import dao.UserDaoImpl;
import model.User;

public class UserRegisterServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		// 获取注册表单的用户名以及密码
		PrintWriter pw = response.getWriter();
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("password");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date  = df.format(new Date());// new Date()为获取当前系统时间
		User user = new User(userName,userPwd,date);
	//	pw.write(user.getUserName()+user.getUserPwd());
		checkRegister checkregister = new checkRegister();
        if(checkregister.IsExit(user)==1){
        	if(checkregister.save(user)==1){
        		response.sendRedirect(request.getContextPath() +"/login.html");  
        		System.out.println("注册成功");
        	}else{
        		System.out.println("注册失败");
        	}
        }else{
        	System.out.println("该账号已存在！啦啦啦啦");
        }
		


	}

}
