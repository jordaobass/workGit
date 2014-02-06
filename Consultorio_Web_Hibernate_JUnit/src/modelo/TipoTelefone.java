package modelo;

public enum TipoTelefone {

	CELULAR("Celular"), RESIDENCIAL("Residencial"), COMERCIAL("Comercial");

	private String label;

	private TipoTelefone(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
