package com.tsms.servlet.taxsource;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaskDaoImpl;


/**
 * Servlet implementation class ToAddTaskServlet
 */
@WebServlet("/toAddTaskServlet.json")
public class ToAddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToAddTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String payerCode = request.getParameter("payerCode");

		TaskDaoImpl tdi = new TaskDaoImpl();
		if(payerCode==null){
			Map<String, String> result = tdi.getTaxPayerById(Integer.parseInt(id));
			if(result.size()<0 || result==null){
				return;
			}
			request.setAttribute("result", result);
			request.getRequestDispatcher("/manage/jsp/addTask.jsp").forward(request, response);	
		}else{
			Map<String, String> result = tdi.getTaxPayerByPayerCode(payerCode);
			if(result.size()<0 || result==null){
				return;
			}
			request.setAttribute("result", result);
			request.getRequestDispatcher("/manage/jsp/addTask.jsp").forward(request, response);	
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
