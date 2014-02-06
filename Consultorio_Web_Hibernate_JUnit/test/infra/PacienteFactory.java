package infra;

import java.util.Date;
import modelo.Consulta;
import modelo.Endereco;
import modelo.NomePlano;
import modelo.Paciente;
import modelo.Plano;

public class PacienteFactory {

	public Paciente criaPacientes(int i) {

		
		
		Paciente paciente = new Paciente();

		//paciente.setCodigo(1);
		paciente.setCpf("1261351509"+i);
		paciente.setNome("Homem Teste"+i);

		paciente.setEndereco(new Endereco());
		paciente.getEndereco().setCep("24220111");

		return paciente;
	}

	public Plano criaPlanos() {
		 Plano plano = new Plano();
			
		 
		 plano.setDataValidade(new Date());
		 plano.setNome(NomePlano.AMIL);
	
		return plano;
	}
	
	public Consulta criarConsulta(int i){

		Consulta consulta = new Consulta();
		consulta.setDataConsulta(new Date());
		consulta.setPaciente(criaPacientes(i));
		consulta.setTipoConsulta("Particular");

		return consulta;
	}
	
	
}
