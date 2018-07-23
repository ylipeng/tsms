package com.tsms.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsms.dao.impl.UserDaoImpl;
import com.tsms.entity.User;
import com.tsms.util.EncryptUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet.do")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		String password = request.getParameter("password");
		
		
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();

		UserDaoImpl udi = new UserDaoImpl();
		User user = udi.getLogin(username);

		if (user == null) {
			json.put("msg", "账号不存在");
			json.put("success", false);
		} else {
			password = EncryptUtil.encryptMD5(password + user.getSalt());
			if (user.getPassword().equals(password)) {
				json.put("msg", "登陆成功");
				json.put("success", true);
				response.addCookie(new Cookie("username", username));
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("user", user);
			} else {
				json.put("msg", "密码错误");
				json.put("success", false);
			}
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
