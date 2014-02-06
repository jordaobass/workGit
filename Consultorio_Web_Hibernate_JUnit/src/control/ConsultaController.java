package control;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import modelo.Consulta;
import modelo.Paciente;
import modelo.dao.ConsultorioService;

public class ConsultaController extends MyDispatch{
	
	public void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
		Consulta consulta = new Consulta();
		consulta.setTipoConsulta(request.getParameter("TipoConsulta"));
		
		String dataConsulta = request.getParameter("data");

		consulta.setPaciente(new Paciente());
		consulta.getPaciente().setCpf(request.getParameter("cpf").replaceAll("\\.|-|_", ""));
		consulta.setPaciente(ConsultorioService.getInstance().recuperarPacientePorCpf(consulta.getPaciente().getCpf()));
			
			Date data = new Date();

			data = ConsultorioService.SDF.parse(dataConsulta);

			consulta.setDataConsulta(data);
						
			if (ConsultorioService.getInstance().verificarConsulta(consulta) != null) {

				request.setAttribute("mensagem", "Data invalida, favor atualizar a pagina!");
				request.getRequestDispatcher("agenda-consulta.jsp").forward(request, response);

			} 
			else if (consulta.getPaciente().getNome() == ""){
				
				request.setAttribute("mensagem", "Preencha todos os campos");
				request.getRequestDispatcher("agenda-consulta.jsp").forward(request, response);
			}
			else {
					
					ConsultorioService.getInstance().cadastrarConsulta(consulta);
					
					ConsultorioService.getInstance().removeData(consulta.getDataConsulta());
					
					request.setAttribute("consulta", consulta);
					request.getRequestDispatcher("consulta-agendada.jsp").forward(request, response);
										
			}
		} catch (ParseException e) {
			e.printStackTrace();
			request.setAttribute("mensagem", "Problemas ao formatar a data. "+e.getMessage());
			request.getRequestDispatcher("agenda-consulta.jsp").forward(request, response);
			
		} 
			
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("agenda-consulta.jsp").forward(request, response);
			
		}
	}
	
	public void gerar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Date date = new Date();

			Calendar dataCalendar = Calendar.getInstance();
			dataCalendar.setTime(date);

			ConsultorioService.getInstance().setData(ConsultorioService.getInstance().ultimaData());

			if (ConsultorioService.getInstance().data() == null) {
			getData(date, dataCalendar);
			request.setAttribute("mensagem", "Datas geradas com sucesso");
			request.getRequestDispatcher("datasGeradas.jsp").forward(request, response);
			} else {

				dataCalendar.setTimeInMillis(ConsultorioService.getInstance().data()
						.getTime());
				getData(date, dataCalendar);
				request.setAttribute("mensagem", "Datas geradas com sucesso");
				request.getRequestDispatcher("datasGeradas.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mensagem", "Problemas na geração de datas! "+e.getMessage());
			request.getRequestDispatcher("datasGeradas.jsp").forward(request, response);
		}
	

	}

	public Consulta getData(Date date, Calendar dataCalendar) throws Exception {

		Consulta consulta = new Consulta();
		
		consulta = ConsultorioService.getInstance().criarDatasDisponiveis(date, dataCalendar);
			
		ConsultorioService.getInstance().cadastrarDataDisponivelAgendada(consulta.getListaDataDisponivel());
						
		return consulta;
			

	}
	public void lista(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Paciente paciente = new Paciente();
		
		try {
			paciente.setCpf(request.getParameter("cpf").replaceAll("\\.|-", ""));
			paciente = ConsultorioService.getInstance().recuperarPacientePorCpf(paciente.getCpf());

			if (paciente.getNome() == null) {

				request.setAttribute("mensagem", "Paciente n&atilde;o encontrado!");
				request.getRequestDispatcher("agenda-consulta.jsp").forward(request, response);

			} else {

				request.setAttribute("paciente", paciente);
				
				//Singleton.getInstance().removeDataDiaAnterior();
				request.getRequestDispatcher("agenda-consulta.jsp").forward(request, response);
			}
		}catch (Exception e) {

			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("agenda-consulta.jsp").forward(request, response);
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
