package modelo;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="plano")
public class Plano{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="nome")
	private NomePlano nome;
	
	@ManyToOne
	@JoinColumn(name = "paciente_fk")
	private Paciente paciente;
	
	@Column(name="data_validade")
	@Temporal(TemporalType.DATE)
	private Date dataValidade;

	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public NomePlano getNome() {
		return nome;
	}
	
	public void setNome(NomePlano nome) {
		this.nome = nome;
	}
	
	public Date getDataValidade() {
		return dataValidade;
	}
	
	/*public Date getDataValidadeDate(){
		return dataValidade.toDate();
	}*/
	
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
}
