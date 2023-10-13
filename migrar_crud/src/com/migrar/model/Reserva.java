package com.migrar.model;

import java.time.LocalDateTime;

public class Reserva {
	private long idReserva;
	private LocalDateTime dataReserva;

	private enum StatusReserva {
		CONFIRMADA, PENDENTE, CANCELADA
	}
	
	public StatusReserva statusReserva;
	private Cliente cliente;
	private Destino destino;

	public Reserva(LocalDateTime dataReserva, StatusReserva statusReserva, Cliente cliente, Destino destino) {
		this.dataReserva = dataReserva;
		this.statusReserva = statusReserva;
		this.cliente = cliente;
		this.destino = destino;
	}

	public Reserva() {

	}

	public long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	public LocalDateTime getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDateTime dataReserva) {
		this.dataReserva = dataReserva;
	}

	public String getStatusReserva() {
		return statusReserva.name();
	}

	public void setStatusReserva(String statusReserva) {
		if ("CONFIRMADA".equalsIgnoreCase(statusReserva)) {
			this.statusReserva = StatusReserva.CONFIRMADA;
		} else if ("PENDENTE".equalsIgnoreCase(statusReserva)) {
			this.statusReserva = StatusReserva.PENDENTE;
		} else if ("CANCELADA".equalsIgnoreCase(statusReserva)) {
			this.statusReserva = StatusReserva.CANCELADA;
		} else {
			System.out.println("Valor invalido: " + statusReserva);
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

}
