package com.tsms.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.UserDaoImpl;
import com.tsms.util.EncryptUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class updateUserPassword
 */
@WebServlet("/updateUserPassword.json")
public class UpdateUserPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserPassword() {
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
		
		String username = request.getParameter("username");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		
		UserDaoImpl udi = new UserDaoImpl();
		String salt = udi.getSaltByUserName(username);
		String password = udi.getPasswordByUserName(username);
		oldPassword = EncryptUtil.encryptMD5(oldPassword+salt);
		newPassword = EncryptUtil.encryptMD5(newPassword+salt);
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();
		if(oldPassword.equals(password)){
			boolean b = udi.updateUserPassword(username, newPassword);
			if(b){
				json.put("msg", "修改成功");
				json.put("success", true);
			}else{
				json.put("msg", "修改失败");
				json.put("success", false);
			}
		}else{
			json.put("msg", "密码有误，请输入正确的密码");
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
