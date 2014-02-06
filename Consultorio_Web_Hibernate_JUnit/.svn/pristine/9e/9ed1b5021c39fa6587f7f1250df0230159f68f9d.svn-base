package modelo.dao;

import java.util.List;
import javax.persistence.Query;
import modelo.Paciente;
import modelo.Plano;



public class PlanoDAO extends BaseDAO{
	
	@SuppressWarnings("unchecked")
	public List<Plano> getPlanos(Paciente paciente) {
		
		Query query = manager.createQuery("select p from Plano p where p.paciente.codigo = " + paciente.getCodigo());
		return query.getResultList();
	}
	
} 

