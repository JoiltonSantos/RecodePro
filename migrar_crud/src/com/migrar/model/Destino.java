package com.migrar.model;

public class Destino {
	private long idDestino;
	private String localDestino;
	private float valorDestino;

	public Destino(String localDestino, float valorDestino) {
		this.localDestino = localDestino;
		this.valorDestino = valorDestino;
	}

	public Destino() {

	}

	public long getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(long idDestino) {
		this.idDestino = idDestino;
	}

	public String getLocalDestino() {
		return localDestino;
	}

	public void setLocalDestino(String localDestino) {
		this.localDestino = localDestino;
	}

	public float getValorDestino() {
		return valorDestino;
	}

	public void setValorDestino(float valorDestino) {
		this.valorDestino = valorDestino;
	}

}
