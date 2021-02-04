package kr.gov.filter01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 *  * 필터(Filter)
 *  	- 브라우저에서 서블릿에 요청을 하거나 응답할때 미리 요청이나 응답과 관련된 여러 작업을 처리하는 기능
 *  	- 요청이나 응답시 공통적인 작업을 처리할때 이용됨.
 *  	- 요청필터 : 사용자인증 및 권한 검사, 요청시 요청 관련 로그 작업, 인코딩 기능
 *  	- 응답필터 : 응답 결과에 대한 암호화 작업, 서비스 시간 측정 
 */

public class LoggingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("필터 제거됨");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("요청이 필터에서 처리됨");
		chain.doFilter(request,response);
		System.out.println("응답이 필터에서 처리됨");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("필터 초기화 됨");
	}
	
	
	

}


