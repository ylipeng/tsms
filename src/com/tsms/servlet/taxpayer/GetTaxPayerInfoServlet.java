package com.tsms.servlet.taxpayer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxpayerDaoImpl;


/**
 * Servlet implementation class getTaxPayerInfoServlet
 */
@WebServlet("/getTaxPayerInfoServlet.json")
public class GetTaxPayerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTaxPayerInfoServlet() {
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
		List<Map<String, String>> list = tdi.getTaxPayerInfoById(Integer.parseInt(id));
		if(list.size()<0 || list==null){
			return;
		}
		request.setAttribute("list", list.get(0));
		request.getRequestDispatcher("/manage/jsp/payerInfo.jsp").forward(request, response);
//		response.sendRedirect("manage/jsp/payerInfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
