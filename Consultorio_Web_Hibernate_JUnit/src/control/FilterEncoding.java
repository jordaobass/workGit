package control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterEncoding implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
//		// System.out.println("abrindo o filtro");
//
//		String encoding = "UTF-8";
//		request.setCharacterEncoding(encoding);
//
		chain.doFilter(request, response);
//
		response.setContentType("text/html; charset=UTF-8");
//		System.out.println("fechando o filtro");
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
