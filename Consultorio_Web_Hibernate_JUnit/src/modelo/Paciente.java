package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_paciente")
	private Long codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name = "datanasc")
	private Date dataNascimento;

	@Column(name = "email")
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "paciente_fk")
	private List<Telefone> telefones = new ArrayList<Telefone>();

	@Embedded
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "paciente_fk")
	private List<Plano> planos = new ArrayList<Plano>();

	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas = new ArrayList<Consulta>();

	public List<Plano> getPlanos() {
		return planos;
	}
	
//	public void setPlanos(List<Plano> planos) {
//		this.planos = planos;
//	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codgpaciente) {
		this.codigo = codgpaciente;
	}
	
	public void setPlanos(List<Plano> planos) {
		   if(this.planos != null && planos != null && !planos.isEmpty()){
		       this.planos.clear();
		       for(int i = 0; i < planos.size(); i++){
		           Plano pl = planos.get(i);
		               this.planos.add(pl);
		       }
		   }
		   else this.planos.clear();
		}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

//	public void setTelefones(List<Telefone> telefones) {
//		this.telefones = telefones;
//	}
	public void setTelefones(List<Telefone> telefones) {
		   if(this.telefones != null && telefones != null && !telefones.isEmpty()){
		       this.telefones.clear();
		       for(int i = 0; i < telefones.size(); i++){
		           Telefone pl = telefones.get(i);
		               this.telefones.add(pl);
		       }
		   }
		   else this.telefones.clear();
		}
	/*
	 * 
	 * public List<Consulta> getConsultas() { return consultas; }
	 * 
	 * public void setConsultas(List<Consulta> consultas) { this.consultas =
	 * consultas; }
	 */

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

}
