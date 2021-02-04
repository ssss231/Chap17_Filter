package kr.gov.filter04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFileFilter implements Filter{
	
	PrintWriter writer = null;

	@Override
	public void destroy() {
		System.out.println("LogFileFilter ����");
		writer.close();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		writer.printf("���� �Ͻ� : %s %n", this.getCurrentTime());
		
		String clientAddr = request.getRemoteAddr();      //��û�� Ŭ���̾�Ʈ IPȹ��
		writer.printf("Ŭ���̾�Ʈ �ּ� : %s %n", clientAddr);
		
		chain.doFilter(request, response);
		
		String contentType = response.getContentType();
		writer.printf("���� ���� : %s %n", contentType);
		writer.printf("---------------------------------------------------%n");
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("logFileFilter �ʱ�ȭ");
		
		String filename = filterConfig.getInitParameter("filename");
		if(filename == null) {				// ������ ���� ��
			throw new ServletException("�α� ������ �̸��� ã�� �� �����ϴ�.");
		}
		
		/*
		 *  �Ű������� �޴� ���� FileWriter������Ʈ���� �����ϴµ�
		 *  true���� ������ ��������� �̾ ��� �αױ���� ����� ���� �Ӽ��� ������ ��.
		 *  PrintWriter�ֽ�Ʈ���� �Ű����� �� true�� autoFlush�� �϶�� �ǹ���.
		 */
		try {
			writer = new PrintWriter(new FileWriter(filename, true), true);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public String getCurrentTime() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sFormat.format(new Date());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
