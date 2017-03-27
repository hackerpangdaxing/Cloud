package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserTest;

public class LogoutServlet extends HttpServlet
 {
     public void doGet(HttpServletRequest req, HttpServletResponse resp)
               throws ServletException,IOException
   {
     resp.setContentType("text/html;charset=utf-8");
       System.out.println("退出咯");
    HttpSession session=req.getSession();
      UserTest user=(UserTest)session.getAttribute("user");
     session.invalidate();
       
    PrintWriter out=resp.getWriter();
    out.println("<html><head><title>退出登录</title></head><body>");
      out.println(user.getName()+"，你已退出登录<br>");
    //  out.println("<a href=login.html>重新登录</a>");
      out.println("</body></html>");
      out.close();
   }
}