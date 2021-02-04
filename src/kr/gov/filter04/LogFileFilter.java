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
		System.out.println("LogFileFilter 해제");
		writer.close();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		writer.printf("접속 일시 : %s %n", this.getCurrentTime());
		
		String clientAddr = request.getRemoteAddr();      //요청한 클라이언트 IP획득
		writer.printf("클라이언트 주소 : %s %n", clientAddr);
		
		chain.doFilter(request, response);
		
		String contentType = response.getContentType();
		writer.printf("문서 유형 : %s %n", contentType);
		writer.printf("---------------------------------------------------%n");
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("logFileFilter 초기화");
		
		String filename = filterConfig.getInitParameter("filename");
		if(filename == null) {				// 파일이 없을 때
			throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		}
		
		/*
		 *  매개변수로 받는 값이 FileWriter보조스트림을 연결하는데
		 *  true값은 파일을 덮어쓰지말고 이어서 계속 로그기록을 남기기 위한 속성을 정의한 것.
		 *  PrintWriter주스트림의 매개변수 중 true은 autoFlush을 하라는 의미임.
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
