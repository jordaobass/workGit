package control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import modelo.dao.ConnectionFactory;

public class FilterTransaction implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException {
	
		//ConnectionFactory connection = new ConnectionFactory();
		System.out.println(HttpServletRequest.class.cast(request).getRequestURI());
		System.out.println("BEGIN");
		ConnectionFactory.begin();
		
		
		//request.setAttribute("conexao", connection);
		try {
			chain.doFilter(request, response);
			System.out.println("COMMIT");
			ConnectionFactory.commit();
		} catch (IOException e) {
			throw new ServletException("Erro ao processar request.", e);
		}
		finally {
			System.out.println("CLOSE");
			ConnectionFactory.close();	
		}
		
	}
	
	/*@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
//		// System.out.println("abrindo o filtro");
//
//		String encoding = "UTF-8";
//		request.setCharacterEncoding(encoding);
//
		ConnectionFactory.begin();
		chain.doFilter(request, response);
//
		ConnectionFactory.commit();
		ConnectionFactory.close();
		//response.setContentType("text/html; charset=UTF-8");
//		System.out.println("fechando o filtro");
	}*/


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
