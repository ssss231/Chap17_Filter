package kr.gov.filter02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenFilter implements Filter{
	
	public AuthenFilter() {
		System.out.println("AuthenFilter ������ ȣ��");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("filter01 ����");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter01.jsp ��û");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		
		if(name == null || name.equals("")) {                          //name���� null�̶�� �Ʒ� doFilter()
			PrintWriter out = response.getWriter();
			out.println("�Էµ� name�� null�Դϴ�.");
			return;
		}
		
		chain.doFilter(request, response);
		System.out.println("filter01.jsp ����");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter01 �ʱ�ȭ");
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
