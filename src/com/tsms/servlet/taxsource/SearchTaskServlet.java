package com.tsms.servlet.taxsource;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaskDaoImpl;
import com.tsms.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class SearchTaskServlet
 */
@WebServlet("/searchTaskServlet.json")
public class SearchTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTaskServlet() {
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
		String payerCode = request.getParameter("payerCode");
		String payerName = request.getParameter("payerName");
		String subOrganId = request.getParameter("subOrganId");
		String industryId = request.getParameter("industryId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		if(StringUtil.isBlank(subOrganId)){
			subOrganId="-1";
		}
		if(StringUtil.isBlank(industryId)){
			industryId="-1";
		}
		TaskDaoImpl tdi = new TaskDaoImpl();
		List<Map<String, String>> list = tdi.getListTaxsource(payerCode,payerName,Integer.parseInt(subOrganId),Integer.parseInt(industryId),startDate,endDate,Integer.parseInt(pageNo), Integer.parseInt(pageSize));
		int total = tdi.getCount(payerCode,payerName,Integer.parseInt(subOrganId),Integer.parseInt(industryId),startDate,endDate);
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();
		
		if(list.size()<0 || list==null){
			return;
		}

		for (Map<String, String> map : list) {
			String executeTime = map.get("executeTime");
			String recordTaskDate = map.get("recordTaskDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long m = 0;
	        try {
				 m = sdf.parse(recordTaskDate).getTime() - sdf.parse(executeTime).getTime();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int timeOut =Math.round(m/1000/3600/24); 
			
			map.put("timeOut", Integer.toString(timeOut));
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
