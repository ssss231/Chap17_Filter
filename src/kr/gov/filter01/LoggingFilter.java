package kr.gov.filter01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 *  * ����(Filter)
 *  	- ���������� ������ ��û�� �ϰų� �����Ҷ� �̸� ��û�̳� ����� ���õ� ���� �۾��� ó���ϴ� ���
 *  	- ��û�̳� ����� �������� �۾��� ó���Ҷ� �̿��.
 *  	- ��û���� : ��������� �� ���� �˻�, ��û�� ��û ���� �α� �۾�, ���ڵ� ���
 *  	- �������� : ���� ����� ���� ��ȣȭ �۾�, ���� �ð� ���� 
 */

public class LoggingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("���� ���ŵ�");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("��û�� ���Ϳ��� ó����");
		chain.doFilter(request,response);
		System.out.println("������ ���Ϳ��� ó����");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("���� �ʱ�ȭ ��");
	}
	
	
	

}


