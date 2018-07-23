package com.tsms.servlet.taxer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxerDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ListTaxerServlet
 */
@WebServlet("/listTaxerServlet.json")
public class ListTaxerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTaxerServlet() {
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
		
		String pageNo = request.getParameter("page");
		String pageSize = request.getParameter("rows");
		String taxerName = request.getParameter("taxerName");
		TaxerDaoImpl tdi = new TaxerDaoImpl();
		List<Map<String, String>> list = tdi.getListTaxer(taxerName,Integer.parseInt(pageNo), Integer.parseInt(pageSize));
		int total = tdi.getTaxerCount(taxerName);
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();
		if(list.size()<0 || list==null){
			return;
		}
		json.put("rows", list);
		json.put("total", total);
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
