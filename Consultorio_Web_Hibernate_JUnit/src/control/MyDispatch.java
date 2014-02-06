package control;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyDispatch implements InterfaceLogica {

	protected MyDispatch() {

	}

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MEU DISPACHO");
		String action = request.getParameter("action");

		if (action == null || action.isEmpty()) {
			throw new ServletException("Parametro ação obrigatorio");
		}

		try {
			Method m = getClass().getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			m.invoke(this, request, response);
		} catch (Exception e) {
			throw new ServletException("Erro ao buscar ação.", e);
		}
	}

}
