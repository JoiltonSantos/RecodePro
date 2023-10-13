package com.migrar.model;

public class Contato {
	private long idContato;
	private String nomeContato;
	private String emailContato;
	private String telefoneContato;
	private String mensagemContato;

	public Contato(String nomeContato, String emailContato, String telefoneContato, String mensagemContato) {
		this.nomeContato = nomeContato;
		this.emailContato = emailContato;
		this.telefoneContato = telefoneContato;
		this.mensagemContato = mensagemContato;
	}

	public Contato() {

	}

	public long getIdContato() {
		return idContato;
	}

	public void setIdContato(long idContato) {
		this.idContato = idContato;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getMensagemContato() {
		return mensagemContato;
	}

	public void setMensagemContato(String mensagemContato) {
		this.mensagemContato = mensagemContato;
	}

}
