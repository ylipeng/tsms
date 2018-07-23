package com.tsms.servlet.taxer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxerDaoImpl;
import com.tsms.entity.Taxer;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddTaxerServlet
 */
@WebServlet("/addTaxerServlet.json")
public class AddTaxerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaxerServlet() {
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
		
		String taxerCode = request.getParameter("taxerCode");
		String taxerName = request.getParameter("taxerName");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String organId = request.getParameter("organId");
		Taxer ta = new Taxer(taxerCode, taxerName, mobile, address, sex, birthday, email, Integer.parseInt(organId));
		TaxerDaoImpl tdi = new TaxerDaoImpl();
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();
		boolean b = tdi.addTaxer(ta);
		
		if(b){
			json.put("msg", "添加成功");
			json.put("success", true);
		}else{
			json.put("msg", "添加失败");
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
