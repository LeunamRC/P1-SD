package br.com.model;
import java.io.Serializable;

public class Cidade implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String uf;
	
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
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
}
