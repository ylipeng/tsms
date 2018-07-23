package com.tsms.servlet.taxpayer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.tsms.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdatePayerImgServlet3
 */
@WebServlet("/updatePayerImg.json")
public class UpdatePayerImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePayerImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		JSONObject js=new JSONObject();
		String uploadPath=request.getServletContext().getRealPath("upload");
		System.out.println(uploadPath);
		File f=new File(uploadPath);
		if(!f.exists()){
			f.mkdirs();
		}
		Part pat=request.getPart("image");
		if(pat!=null){
			String fileName=pat.getSubmittedFileName();
			//获取文件大小
			long l=pat.getSize();
			if(l>10*1024*1024){
				js.put("result", false);
				js.put("msg", "图片大小不能超过10M");
			}else if(StringUtil.isNotBlank(fileName)){
				js.put("result", false);
				js.put("msg", "上传图片不能为空");
			}else{
				fileName=UUID.randomUUID()+fileName;
				pat.write(uploadPath+"/"+fileName);
				js.put("result", true);
				js.put("msg", "上传成功");
				js.put("url", request.getContextPath()+"/upload/"+fileName);
			}
	}
		out.print(js.toString());
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
