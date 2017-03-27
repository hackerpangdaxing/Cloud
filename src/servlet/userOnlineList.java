package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserList;
import bean.UserTest;

/**
 * @author 胖大星 显示签到人数列表
 */
public class userOnlineList extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("hello");
		PrintWriter pw = response.getWriter();
		pw.print("失败");

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		userName = new String(userName.getBytes("ISO-8859-1"), "utf-8");

		// 用于
		response.setIntHeader("Refresh", 5); // 定时刷新页面
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		UserTest user = (UserTest) session.getAttribute(userName);
		if (null == user || !userName.equals(user.getName())) {
			user = new UserTest(userName);
			session.setAttribute(userName, user);
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		PrintWriter pw = response.getWriter();
		pw.println("<body style='background-image:url(../a.png);background-position:center;background-size:cover;'/><div style='font-family:微软雅黑;font-size:20px;color:#FFA700;'><br><br><br>祝贺您："
				+ userName + "&nbsp;&nbsp;已签到");
		UserList ul = UserList.getInstance();
		pw.println("<br>当前已签到的同学列表：<br>");
		Enumeration<String> enums = ul.getUserList();
		int i = 0;
		while (enums.hasMoreElements()) {
			pw.println(enums.nextElement()); // 遍历在线用户
			pw.println("&nbsp;&nbsp;&nbsp;&nbsp;<br>");
			if (++i == 10) {
				pw.println("<br>");
			}
		}
		pw.println("<br>目前已签到的用户数：" + i + "<br>当前时间：" + time + "</div></body>");
		// pw.println("<p><a href=LogoutServlet>退出登录</a>");
		pw.close();
	}
}
