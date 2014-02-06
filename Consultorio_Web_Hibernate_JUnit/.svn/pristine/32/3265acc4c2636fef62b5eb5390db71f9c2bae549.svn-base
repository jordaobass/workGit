package modelo.dao;

import java.util.Date;

import modelo.Endereco;
import modelo.NomePlano;
import modelo.Paciente;
import modelo.Plano;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlanoDAOTest {


	@Before
	public void begin() {
		ConnectionFactory.begin();
	}

	@After
	public void commit() {
		ConnectionFactory.commit();
	}

	@Test
	public void cadastrarUmPlano() {

		try {
			Paciente paciente = new Paciente();
			paciente.setCpf("52280328860");
			paciente.setNome("Homem Teste Plano");

			paciente.setEndereco(new Endereco());
			paciente.getEndereco().setCep("03355010");
			ConsultorioService.getInstance().cadastrar(paciente);
			Assert.assertNotNull(paciente.getCodigo());

			Plano plano = new Plano();
			plano.setPaciente(paciente);
			plano.setDataValidade(new Date());
			plano.setNome(NomePlano.AMIL);
			paciente.getPlanos().add(plano);

			ConsultorioService.getInstance().alterar(paciente);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void cadastrarDoisPlanos() {

		try {
			Paciente paciente = new Paciente();
			paciente.setCpf("12345678985");
			paciente.setNome("Homem Teste Plano");

			paciente.setEndereco(new Endereco());
			paciente.getEndereco().setCep("03355010");
			ConsultorioService.getInstance().cadastrar(paciente);
			Assert.assertNotNull(paciente.getCodigo());

			Plano plano = new Plano();
			plano.setPaciente(paciente);
			plano.setDataValidade(new Date());
			plano.setNome(NomePlano.ASSIM);
			paciente.getPlanos().add(plano);

			Plano plano2 = new Plano();
			plano2.setPaciente(paciente);
			plano2.setDataValidade(new Date());
			plano2.setNome(NomePlano.UNIMED);
			paciente.getPlanos().add(plano2);

			ConsultorioService.getInstance().alterar(paciente);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void excluirPlano() {

		try {

			Paciente paciente = ConsultorioService.getInstance().consultarPacientePorCPF("52280328860");
			Assert.assertNotNull(paciente);

			Plano plano2 = new Plano();
			plano2.setPaciente(paciente);
			plano2.setDataValidade(new Date());
			plano2.setNome(NomePlano.UNIMED);
			paciente.getPlanos().add(plano2);

			ConsultorioService.getInstance().alterar(paciente);
			paciente.getPlanos().remove(0);
			ConsultorioService.getInstance().alterar(paciente);
			Assert.assertSame(1, paciente.getPlanos().size());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void excluirTodosPlanos() {

		try {

			Paciente paciente = ConsultorioService.getInstance().consultarPacientePorCPF("52280328860");
			Assert.assertNotNull(paciente);

			Plano plano = new Plano();
			plano.setPaciente(paciente);
			plano.setDataValidade(new Date());
			plano.setNome(NomePlano.ASSIM);
			paciente.getPlanos().add(plano);

			Plano plano2 = new Plano();
			plano2.setPaciente(paciente);
			plano2.setDataValidade(new Date());
			plano2.setNome(NomePlano.AMIL);
			paciente.getPlanos().add(plano2);

			ConsultorioService.getInstance().alterar(paciente);
			//paciente.getP2lanos().removeAll(paciente.getPlanos());
			paciente.getPlanos().clear();
			ConsultorioService.getInstance().alterar(paciente);
			Assert.assertSame(0, paciente.getPlanos().size());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}
	
	@Test
	public void pegarPlanos(){
		try {
			Paciente paciente = new Paciente();
			paciente.setCpf("12345621985");
			paciente.setNome("Homem Teste pegarPlano");

			paciente.setEndereco(new Endereco());
			paciente.getEndereco().setCep("03355010");
			ConsultorioService.getInstance().cadastrar(paciente);
			Assert.assertNotNull(paciente.getCodigo());

			Plano plano = new Plano();
			plano.setPaciente(paciente);
			plano.setDataValidade(new Date());
			plano.setNome(NomePlano.ASSIM);
			paciente.getPlanos().add(plano);

			Plano plano2 = new Plano();
			plano2.setPaciente(paciente);
			plano2.setDataValidade(new Date());
			plano2.setNome(NomePlano.UNIMED);
			paciente.getPlanos().add(plano2);

			ConsultorioService.getInstance().alterar(paciente);
			Assert.assertEquals(ConsultorioService.getInstance().getPlanos(paciente).size(), 2);


		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	

}
