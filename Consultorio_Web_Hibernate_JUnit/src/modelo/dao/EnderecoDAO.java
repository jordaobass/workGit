package modelo.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;
import modelo.Endereco;
import modelo.Paciente;

public class EnderecoDAO extends BaseDAO {

	public void cadastrarEndereco(Paciente paciente) throws SQLException {
		//begin();

		Endereco endereco = new Endereco();
		endereco = paciente.getEndereco();
		manager.persist(endereco);
		//commit();
		
	}

	@SuppressWarnings("unchecked")
	public List<Endereco> getEndereco(Paciente paciente) throws SQLException {

		Query query = manager.createQuery("select e from Endereco e");

		return query.getResultList();

		// return null;

	}

	public void alteraEndereco(Paciente paciente) throws SQLException {
		//begin();
		Endereco endereco = new Endereco();
		endereco = paciente.getEndereco();
		manager.merge(endereco);
		//commit();

	}
}
