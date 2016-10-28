package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * ����:highchartsʾ�������ں�̨��������
 * 
 * @author Administrator
 * 
 */
public class CreateData extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charsest=utf-8");
		PrintWriter out = response.getWriter();
		/*
		 * 1.���ȶ���һ��map�����û����Ҫչ������
		 */
		Map<String,Object> map = new HashMap<String,Object>();
		//��Ӧ��y������
		map.put("y",Math.random()*10+1);
		//��Ӧ��x������
		map.put("x", new Date().getTime());
		//��map����ת��Ϊjson����
		JSONObject jsonObject = JSONObject.fromObject(map);
		out.print(jsonObject);

	}
}
