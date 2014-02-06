package modelo.dao;

import java.util.List;

import javax.persistence.Query;

import modelo.Paciente;

public class PacienteDAO extends BaseDAO {

	public void cadastrar(Paciente paciente) throws Exception {

		try {
			System.out.println(paciente.getCpf());
			manager.persist(paciente);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Paciente recuperarPacientePorCpf(String cpf) throws Exception {

		try{
			Query query = manager.createQuery("select p from Paciente p where p.cpf = :cpf");
			query.setParameter("cpf", cpf);
	
			return (Paciente) query.getSingleResult();
		}catch(Exception e){
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<Paciente> listarTodosPacientes() throws Exception {

		Query query = manager.createQuery("select p from Paciente p");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Paciente> listarPacientePorNome(String nome) throws Exception {
		
		Query query = manager.createQuery("select p from Paciente p where p.nome like '%"+ nome +"%'");
	
		return query.getResultList();

	}

	public void alterar(Paciente paciente) throws Exception {
		
		try{
			manager.merge(paciente);
			System.out.println("ALTERADO!");
			
		}catch(Exception e){
			e.printStackTrace();
			
			throw e; 
		}
	}

	public void excluir(Paciente paciente) throws Exception {
		try {
			
			paciente.getPlanos().clear();
			paciente.getTelefones().clear();
			paciente.getConsultas().clear();
			manager.remove(paciente);
			System.out.println("Excluido!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
			throw e;
		}
	}


	public Paciente consultarPacientePorCPF(String cpf) throws Exception {

		Query query = manager.createQuery("select p from Paciente p where p.cpf = :cpf");
		query.setParameter("cpf", cpf);

		return (Paciente) query.getSingleResult();
		
		

	}
	
	public Paciente consultarPaciente(String id) {

		return (Paciente) manager.find(Paciente.class, Long.valueOf(id));

	}

}
