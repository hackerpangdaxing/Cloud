package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserList;
import bean.UserTest;

public class getUserSessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		PrintWriter pw = response.getWriter();
		
		HttpSession session=request.getSession();
        UserTest user1=(UserTest)session.getAttribute("username");
        if(null==user1 || !userName.equals(user1.getName()))
     {
          user1 =new UserTest(userName);
         session.setAttribute("username",user1);
        }
    
       response.setContentType("text/html;charset=utf-8");
       
    
        pw.println("欢迎用户：<b>"+userName+"</b>登录");
        UserList ul=UserList.getInstance();
     pw.println("<br>当前在线的用户列表：<br>");
  Enumeration<String> enums=ul.getUserList();
        int i=0;
     while(enums.hasMoreElements())
      {
         pw.println(enums.nextElement());
        pw.println("&nbsp;&nbsp;&nbsp;&nbsp;");
     if(++i==10)
       {
                pw.println("<br>");
        }
    }
      pw.println("<br>当前在线的用户数："+i);
        pw.println("<p><a href=LogoutServlet>退出登录</a>");
      pw.close();

		
/*
		HttpSession session = request.getSession();  //获取用户名
		String userName = (String) session.getAttribute("user");
		
		response.getWriter().write(userName);*/
	}

}
