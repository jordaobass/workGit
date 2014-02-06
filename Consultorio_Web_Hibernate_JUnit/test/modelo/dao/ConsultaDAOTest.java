package modelo.dao;

import java.util.Calendar;
import java.util.Date;

import modelo.Consulta;
import modelo.Endereco;
import modelo.Paciente;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import control.ConsultaController;

public class ConsultaDAOTest {

	@BeforeClass
	public static void init() {

	}

	@AfterClass
	public static void finish() {

	}

	@Test
	public void getData() {
		gerarData();
		verificarUltimaData();

	}

	private void gerarData() {

		Consulta consulta = new Consulta();
		Calendar dataCalendar = Calendar.getInstance();
		Date date = new Date();
		ConsultaController cc = new ConsultaController();

		try {

			consulta = cc.getData(date, dataCalendar);

			Assert.assertNotNull(ConsultorioService.getInstance().getLista());

			Assert.assertEquals(ConsultorioService.getInstance().getLista().size(),
					consulta.getListaDataDisponivel().size());

		} catch (Exception e) {

			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	
	@Test
	public void verificarUltimaData() {

		try {
			Date data = new Date();
			data = ConsultorioService.getInstance().ultimaData();
			
			Assert.assertNotNull(data);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void marcarConsultaParaUmPaciente() throws Exception {

		try {
			Consulta consulta = new Consulta();
			Paciente paciente = new Paciente();

			paciente.setCpf("12345678987");
			paciente.setNome("Pripri");
			paciente.setEndereco(new Endereco());
			paciente.getEndereco().setCep("24240070");

			ConsultorioService.getInstance().cadastrar(paciente);
			consulta.setPaciente(ConsultorioService.getInstance().consultarPacientePorCPF(
					"12345678987"));
			consulta.setDataConsulta(new Date());
			consulta.setTipoConsulta("AMS");

			paciente.getConsultas().add(consulta);
			ConsultorioService.getInstance().alterar(paciente);
			ConsultorioService.getInstance().cadastrarConsulta(consulta);

			Assert.assertEquals(ConsultorioService.getInstance().getConsultas(paciente)
					.size(), 1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void desmarcarConsulta() throws Exception {

		try {
			Consulta consulta = new Consulta();
			Paciente paciente = new Paciente();

			paciente.setCpf("12345678965");
			paciente.setNome("Pripri Dois");
			paciente.setEndereco(new Endereco());
			paciente.getEndereco().setCep("35240070");

			ConsultorioService.getInstance().cadastrar(paciente);
			consulta.setPaciente(paciente);
			consulta.setDataConsulta(new Date());
			consulta.setTipoConsulta("DIX");

			paciente.getConsultas().add(consulta);

			ConsultorioService.getInstance().cadastrarConsulta(consulta);
			paciente.getConsultas().remove(0);
			ConsultorioService.getInstance().desmarcarConsulta(consulta);

			Assert.assertEquals(ConsultorioService.getInstance().getConsultas(paciente)
					.size(), 0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}
}
