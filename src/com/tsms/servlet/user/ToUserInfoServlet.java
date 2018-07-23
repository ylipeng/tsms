package com.tsms.servlet.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class ToUserInfoServlet
 */
@WebServlet("/toUserInfoServlet.json")
public class ToUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		
		UserDaoImpl udi = new UserDaoImpl();
		Map<String, String> result = udi.getUserInfoByUsername(username);
		if(result.size()<0 || result==null){
			return;
		}
		String recordDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		result.put("recordDate", recordDate);
		request.setAttribute("result", result);
		request.getRequestDispatcher("/manage/jsp/userInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
