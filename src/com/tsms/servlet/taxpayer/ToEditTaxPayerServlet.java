package com.tsms.servlet.taxpayer;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxpayerDaoImpl;

/**
 * Servlet implementation class toEditTaxPayerServlet
 */
@WebServlet("/toEditTaxPayerServlet.json")
public class ToEditTaxPayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToEditTaxPayerServlet() {
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
		TaxpayerDaoImpl tdi = new TaxpayerDaoImpl();
		Map<String, String> result = tdi.updateTaxPayerById(Integer.parseInt(id));
		
		if(result.size()<0 || result==null){
			return;
		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("/manage/jsp/editTaxPayer.jsp").forward(request, response);
//		response.sendRedirect("/manage/jsp/editTaxPayer.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
