package modelo.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Consulta;
import modelo.Data;
import modelo.Paciente;

public class ConsultaDAO extends BaseDAO {

	public void removeDataDiaAnterior() throws Exception {

		try {

			
			//Date dataHoje = new Date();
			Query query = manager.createQuery("delete from Data d where d.dataDisponivel = :dataHoje");
			query.setParameter("dataHoje", new Date());
			query.executeUpdate();
			

		} catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

	public void removeData(Date data) throws Exception {

		try {
		
			Query query = manager.createQuery("delete Data d where d.dataDisponivel = :data");
			query.setParameter("data", data);
			query.executeUpdate();
			//commit();
			System.out.println("removeu a data");

		} catch (Exception e) {
			e.printStackTrace();
			//rollback();
			throw e;
		}
	}

	public void cadastrarConsulta(Consulta consulta) throws Exception {
		try {

			manager.persist(consulta);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	public Date ultimaData() throws Exception {
		
		Query query = manager.createQuery("select max(d.dataDisponivel) as maximo from Data as d");

		return (Date) query.getSingleResult();

	}

	public Consulta verificarConsulta(Consulta consulta) throws Exception {


			// consultaEncontrada = (Consulta) session.load(Consulta.class,
			// consulta.getCodigo());
		try {	
			
			Query query = manager.createQuery("select c from Consulta c where c.dataConsulta = :data");
			query.setParameter("data", consulta.getDataConsulta());
			
			consulta = (Consulta) query.getSingleResult();
		} 
		catch(NoResultException e){
			consulta = null;
			return consulta;
		}
			
			return consulta;
	}

	public void cadastrarDataDisponivelAgendada(List<Date> datas)
			throws Exception {

		try {
			//manager.getTransaction().begin();

			for (Date date : datas) {

				Data d = new Data();
				d.setDataDisponivel(date);
				manager.persist(d);
			}

			//manager.getTransaction().commit();

		} catch (Exception e) {

			//manager.getTransaction().rollback();
			throw new Exception("Ocorreu um erro ao cadastrar a data disponivel agendada",e);

		}
	}

	@SuppressWarnings("unchecked")
	public List<Data> getLista() throws Exception {
		Query query = manager
				.createQuery("select d from Data d order by d.dataDisponivel");
	
		return (List<Data>) query.getResultList();
	}

	public void desmarcarConsulta(Consulta consulta) throws SQLException {

		try {
			//begin();
			Query query = manager.createQuery("delete from Consulta c where c.dataConsulta = :data");
			query.setParameter("data", consulta.getDataConsulta());
			//manager.remove(consulta);
			query.executeUpdate();
			//commit();
		} catch (Exception e) {
			//rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Consulta> getConsultas(Paciente paciente) throws Exception {

		try {

			// Query query =
			// manager.createQuery("SELECT * FROM consulta WHERE cod_paciente = "+paciente.getCodigo()+
			// " order by data desc limit 1");
		
		//	manager.getTransaction().begin();			
			Query query = manager
					.createQuery("SELECT c FROM Consulta c WHERE c.paciente = :paciente");
			
			query.setParameter("paciente", paciente);
			
			List<Consulta> consultas = query.getResultList();

			/*
			 * PreparedStatement ps =
			 * ConnectionFactory.getConnection().prepareStatement
			 * ("SELECT * FROM consulta WHERE cod_paciente = "
			 * +paciente.getCodigo()+ " order by data desc limit 1"); ResultSet
			 * rs = ps.executeQuery();
			 * 
			 * List<Consulta> consultas = new ArrayList<Consulta>();
			 * 
			 * if (rs.next()) {
			 * 
			 * Consulta consulta = new Consulta();
			 * consulta.setCodigo(rs.getInt("cod_consulta"));
			 * consulta.setDataConsulta(new
			 * Timestamp(rs.getTimestamp("data").getTime()));
			 * consultas.add(consulta); }
			 */

			return consultas;
		} catch (Exception e) {

			throw new Exception("Ocorreu algum erro", e);

		}
		
	}
	
	public void recadastrarDataDaConsultaDesmarcada(Data data){
		
		manager.persist(data);
	}
}
