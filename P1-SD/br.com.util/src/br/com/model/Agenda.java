package br.com.model;

import java.io.Serializable;

public class Agenda implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int id_contato;
	private String dt_agendamento;
	private String horario;
	private String obs;
	private String situacao;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_contato() {
		return id_contato;
	}
	public void setId_contato(int id_contato) {
		this.id_contato = id_contato;
	}
	public String getDt_agendamento() {
		return dt_agendamento;
	}
	public void setDt_agendamento(String dt_agendamento) {
		this.dt_agendamento = dt_agendamento;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
