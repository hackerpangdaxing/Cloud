package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DbUtil;
import bean.Problem;
import model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ProblemJsonServlet extends HttpServlet {
	public ProblemJsonServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("application/x-json");      //此方法运行时会直接自动下载生成json格式的文件
		response.setCharacterEncoding("utf-8");
		response.addHeader("Access-Control-Allow-Origin","*");      //此方法很重要  用于前端解析json文件
		PrintWriter pw = response.getWriter();
		//System.out.println("ni hao");
		//System.out.print("faslfhuaf");
		DbUtil dbUtil = new DbUtil();
		Connection con;
		try {
			con = dbUtil.getCloudClassCon();
			String sql = "select * from problem where id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  request.getParameter("id"));
			ResultSet rs = pstmt.executeQuery(); // 光标指向上一行，有则返回true 没有就返回false
			//System.out.println("hello");
			if (rs.next()) {
				//System.out.println("hello1");
                int id = rs.getInt("id"); //获取题目ID
				Clob c = rs.getClob("problem");
				String problem = c.getSubString(1, (int) c.length());   //获取题目文本
                
				Blob b = rs.getBlob("pic");   //获取题目附带图片

				Clob c1 = rs.getClob("answer");    //获取答案
				String answer = c1.getSubString(1, (int) c1.length());
				
				Clob choose1 = rs.getClob("chooseA");
				String chooseA = choose1.getSubString(1,(int)choose1. length());
				
				Clob choose2 = rs.getClob("chooseB");
				String chooseB = choose2.getSubString(1,(int)choose2. length());
				
				Clob choose3 = rs.getClob("chooseC");
				String chooseC = choose3.getSubString(1,(int)choose3. length());
				
				Clob choose4 = rs.getClob("chooseD");
				String chooseD = choose4.getSubString(1,(int)choose4. length());

				int sore = rs.getInt("sore");    //获取题目分值
				
				ArrayList<Problem> items = new ArrayList<Problem>();
				items.add(new Problem(id,problem,sore,b,chooseA,chooseB,chooseB,chooseC,chooseD,answer));
               
				JSONArray jsonArray = new JSONArray();
				jsonArray.addAll(items);
				pw.print(jsonArray.toString()); // 将String转成json发送！
			    pw.flush();
				pw.close();

			}
			dbUtil.close(pstmt, con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
	}
}