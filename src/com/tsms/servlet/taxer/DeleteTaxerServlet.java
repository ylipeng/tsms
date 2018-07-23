package com.tsms.servlet.taxer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxerDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class eleteTaxerServlet
 */
@WebServlet("/deleteTaxerServlet.json")
public class DeleteTaxerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTaxerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json;charset=UTF-8");
		
		String id = request.getParameter("id");
	
		TaxerDaoImpl tdi = new TaxerDaoImpl();
		boolean b = tdi.deleteTaxer(Integer.parseInt(id));
	
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();
		if(b){
			json.put("msg", "删除成功");
			json.put("success", true);
		}else{
			json.put("msg", "删除失败");
			json.put("success", false);
			
		}
		
		out.write(json.toString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
