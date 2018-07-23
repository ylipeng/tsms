package com.tsms.servlet.taxsource;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.TaskDaoImpl;
import com.tsms.entity.Taxsource;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class EditTaskServlet
 */
@WebServlet("/editTaskServlet.json")
public class EditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTaskServlet() {
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
		String payerId = request.getParameter("payerId");
		String subOrganId = request.getParameter("subOrganId");
		String approverId = request.getParameter("approverId");
		String executeId = request.getParameter("executeId");
		String executeTime = request.getParameter("executeTime");
		String taskState = request.getParameter("taskState");
		
		Taxsource ts = new Taxsource(Integer.parseInt(id), Integer.parseInt(payerId), Integer.parseInt(subOrganId), Integer.parseInt(approverId), Integer.parseInt(executeId), executeTime, taskState);
		TaskDaoImpl tdi = new TaskDaoImpl();
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();
		boolean b = tdi.updateTask(ts);
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
