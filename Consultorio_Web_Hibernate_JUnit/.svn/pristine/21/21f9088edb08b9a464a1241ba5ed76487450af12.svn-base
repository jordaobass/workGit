package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1609992028134033653L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processaRequisicao(request, response);
	}
	
	protected void processaRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CONTROLLERSERVLET");
		String parametro = request.getParameter("logica");
		String nomeClasse = "control." + parametro;
		
		try {
			Class<?> classe = Class.forName(nomeClasse);
			InterfaceLogica logica = (InterfaceLogica) classe.newInstance();
			logica.executa(request, response);
		} catch (Exception e) {
			
			throw new ServletException("Erro ao processo interface lógica.", e);
		}
	}

}
