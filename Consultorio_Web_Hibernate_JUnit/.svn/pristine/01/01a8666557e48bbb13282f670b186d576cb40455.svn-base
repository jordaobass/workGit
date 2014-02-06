package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Data;
import modelo.NomePlano;
import modelo.Paciente;
import modelo.Plano;
import modelo.TipoTelefone;
import modelo.dao.ConsultorioService;

public class ListaDataConsulta implements InterfaceLogica {

	

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public List<TipoTelefone> getTiposTelefone() {
		return Arrays.asList(TipoTelefone.values());
	}

	public List<NomePlano> getNomePlanos() {

		return Arrays.asList(NomePlano.values());
	}

	public List<String> getDataPlano(Paciente paciente) {

		List<String> dataFormatada = new ArrayList<String>();
		
		  for (Plano plano : paciente.getPlanos()) {
		  
		  dataFormatada.add(plano.getDataValidade().toString(/*"MM/yyyy"*/));
		  
		 }
		 
		return dataFormatada;
	}

	public List<String> getData() throws Exception {
		ConsultorioService.getInstance().removeDataDiaAnterior();
		List<String> dataFormatada = new ArrayList<String>();
		
		for (Data listaData : ConsultorioService.getInstance().getLista()) {
			
			dataFormatada.add(ConsultorioService.SDF.format(listaData.getDataDisponivel()));
		}
		
		return dataFormatada;

	}
}
