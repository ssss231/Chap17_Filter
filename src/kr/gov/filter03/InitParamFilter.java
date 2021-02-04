package kr.gov.filter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitParamFilter implements Filter{
	
	private FilterConfig filterConfig = null;
	
	
	@Override
	public void destroy() {
		System.out.println("filter02 ����");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter02 ����");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//web.xml���� <initParam>�±׷� ������ �� �޾ƿ��� �ڵ�
		String param1 = filterConfig.getInitParameter("param1");
		String param2 = filterConfig.getInitParameter("param2");
		
		String message;
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		if(id.equals(param1) && pw.equals(param2)) {
			message = "�α��� ����";
			
		}
		else {
			message = "�α��� ����";
		}
		
		PrintWriter out = response.getWriter();
		out.println(message);
		chain.doFilter(request, response);
		
		System.out.println("filter02 �Ϸ�");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter02 �ʱ�ȭ");
		this.filterConfig = filterConfig;
		
	}

}
