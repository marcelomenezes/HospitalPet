package modelo;

public class Pet {


	int id;
	String nome;
	String especie;
	String raca;
	boolean urgente;
	String necessita;
	
	
	public Pet(int id, String nome, String especie, String raca, 
			boolean urgente, String necessita) {
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.urgente = urgente;
		this.necessita = necessita;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public String getRaca() {
		return raca;
	}


	public void setRaca(String raca) {
		this.raca = raca;
	}


	public boolean isUrgente() {
		return urgente;
	}


	public void setUrgente(boolean urgente) {
		this.urgente = urgente;
	}


	public String getNecessita() {
		return necessita;
	}


	public void setNecessita(String necessita) {
		this.necessita = necessita;
	}

}
