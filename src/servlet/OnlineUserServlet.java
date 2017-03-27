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

public class OnlineUserServlet extends HttpServlet
{
   public void doGet(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException,IOException
  {
        request.setCharacterEncoding("gb2312");
        String userName=request.getParameter("username");
     String userPwd=request.getParameter("password");
           
     if(null==userName || null==userPwd || userName.equals("") || userPwd.equals(""))
     {
             response.sendRedirect("login.html");
        }
    else
       {
              HttpSession session=request.getSession();
              UserTest user=(UserTest)session.getAttribute("user");
              if(null==user || !userName.equals(user.getName()))
           {
                user=new UserTest(userName);
               session.setAttribute("user",user);
              }
          
             response.setContentType("text/html;charset=gb2312");
              PrintWriter out=response.getWriter();
          
              out.println("欢迎用户<b>"+userName+"</b>登录");
              UserList ul=UserList.getInstance();
           out.println("<br>当前在线的用户列表：<br>");
        Enumeration<String> enums=ul.getUserList();
              int i=0;
           while(enums.hasMoreElements())
            {
               out.println(enums.nextElement());
              out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
           if(++i==10)
             {
                      out.println("<br>");
              }
          }
            out.println("<br>当前在线的用户数："+i);
              out.println("<p><a href=LogoutServlet>退出登录</a>");
            out.close();
        }
    }
   
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                  throws ServletException,IOException
    {
        doGet(req,resp);
    }
}