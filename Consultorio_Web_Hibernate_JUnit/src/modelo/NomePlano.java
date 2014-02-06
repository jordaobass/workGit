package modelo;

public enum NomePlano {
	
	UNIMED("Unimed"), AMIL("Amil"), AMS("Ams"), GOLDENCROSS("Golden Cross"), DIX("DIX"), ASSIM("Assim"), SEMPLANO("Sem Plano");
		
	private String label;
		
	private NomePlano(String label) {
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
}

