package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_consulta")
	private Long codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data")
	private Date dataConsulta;
	
	@Column(name="tipo_consulta")
	private String tipoConsulta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_PACIENTE")
	private Paciente paciente;
	
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	@Transient
	protected List<Date> listaDataDisponivel = new ArrayList<Date>();


	public List<Date> getListaDataDisponivel() {
		return listaDataDisponivel;
	}

	public void setListaDataDisponivel(List<Date> listaDataDisponivel) {
		this.listaDataDisponivel = listaDataDisponivel;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Consulta [dataConsulta=" + dataConsulta + ", Tipo=" + tipoConsulta
				+ "]";
	}
}
