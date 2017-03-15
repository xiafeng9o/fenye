package com.feng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.feng.entity.User;
import com.feng.dao.UserDao;

public class ListUser extends HttpServlet {
	public ListUser() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//测试git123
		response.setCharacterEncoding("utf-8");
		int pageNo = 1;
		UserDao userdao = new UserDao();
		List<User> lists = new ArrayList<User>();
		String pageno = request.getParameter("pageNos");
		if (pageno != null) {
			pageNo = Integer.parseInt(pageno);
		}
		lists = userdao.listUser(pageNo);
		int recordCount = userdao.getPage();
		request.setAttribute("recordCount", userdao.getPage());
		request.setAttribute("listss", lists);
		request.setAttribute("pageNos", pageNo);
		request.getRequestDispatcher("fenye.jsp").forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}
}