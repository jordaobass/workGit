package modelo.dao;


import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;
import modelo.Paciente;
import modelo.Telefone;

public class TelefoneDAO extends BaseDAO {

	@SuppressWarnings("unchecked")
	public List<Telefone> getTelefones(Paciente paciente) throws SQLException {

	Query query = manager.createQuery("SELECT t FROM Telefone t WHERE t.paciente = :paciente");
	query.setParameter("paciente", paciente);
	
	
	return query.getResultList();
	}

}
