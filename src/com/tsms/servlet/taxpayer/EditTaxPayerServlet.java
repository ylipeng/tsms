package com.tsms.servlet.taxpayer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaxpayerDaoImpl;
import com.tsms.entity.Taxpayer;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class editTaxPayerServlet
 */
@WebServlet("/editTaxPayerServlet.json")
public class EditTaxPayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTaxPayerServlet() {
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
		String payerName = request.getParameter("payerName");
		String bizAddress = request.getParameter("bizAddress");
		String bizAddressPhone = request.getParameter("bizAddressPhone");
		String taxOrganId = request.getParameter("taxOrganId");
		String industryId = request.getParameter("industryId");
		String bizScope = request.getParameter("bizScope");
		String invoiceType = request.getParameter("invoiceType");
		String legalPerson = request.getParameter("legalPerson");
		String legalIdCard = request.getParameter("legalIdCard");
		String finaceName = request.getParameter("finaceName");
		String finaceIdCard = request.getParameter("finaceIdCard");
		

		Taxpayer tp = new Taxpayer(Integer.parseInt(id), payerName, bizAddress, Integer.parseInt(taxOrganId), Integer.parseInt(industryId), bizScope, invoiceType, legalPerson, legalIdCard, finaceName, finaceIdCard, bizAddressPhone);
		
		TaxpayerDaoImpl tdi = new TaxpayerDaoImpl();
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();
		boolean b = tdi.updateTaxPayerInfo(tp);
		if(b){
			json.put("msg", "修改成功");
			json.put("success", true);
		}else{
			json.put("msg", "修改失败");
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
