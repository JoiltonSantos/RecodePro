package com.migrar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.migrar.model.Cliente;
import com.migrar.model.Destino;
import com.migrar.model.Reserva;
import com.migrar.utils.Colors;

public class ReservaDAO {
	private static String sql;
	private final Connection connection;

	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}

	public void criarReserva(Reserva reserva) {
		sql = "INSERT INTO reserva (dataReserva, statusReserva, idCliente, idDestino) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			Timestamp sqlDataReserva = Timestamp.valueOf(reserva.getDataReserva());
			stmt.setTimestamp(1, sqlDataReserva);
			stmt.setString(2, reserva.getStatusReserva());
			stmt.setLong(3, reserva.getCliente().getIdCliente());
			stmt.setLong(4, reserva.getDestino().getIdDestino());
			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Reserva feita com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarReservas() {
		sql = "SELECT * FROM reserva as r " + "INNER JOIN cliente as c " + "ON r.idCliente = c.idCliente "
				+ "INNER JOIN destino as d " + "ON r.idDestino = d.idDestino";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Reserva reserva = new Reserva();
				reserva.setIdReserva(r.getLong("idReserva"));
				reserva.setDataReserva(r.getTimestamp("dataReserva").toLocalDateTime());
				reserva.setStatusReserva(r.getString("statusReserva"));

				Cliente cliente = new Cliente();
				cliente.setIdCliente(r.getLong("idCliente"));
				cliente.setNomeCliente(r.getString("nomeCliente"));
				cliente.setCpfCliente(r.getString("cpfCliente"));
				cliente.setEmailCliente(r.getString("emailCliente"));
				cliente.setTelefoneCliente(r.getString("telefoneCliente"));

				Destino destino = new Destino();
				destino.setIdDestino(r.getLong("idDestino"));
				destino.setLocalDestino(r.getString("localDestino"));
				destino.setValorDestino(r.getFloat("valorDestino"));

				System.out.println("DADOS DO PEDIDO" + "\nCódigo do pedido: " + reserva.getIdReserva()
						+ "\nData da viagem: " + reserva.getDataReserva() + "\nSituação do pedido: "
						+ reserva.getStatusReserva() + "\n\nDADOS DO CLIENTE" + "\nCódigo do cliente: "
						+ cliente.getIdCliente() + "\nNome do Cliente: " + cliente.getNomeCliente() + "\nE-MAIL: "
						+ cliente.getEmailCliente() + "\nCPF: " + cliente.getCpfCliente() + "\nTelefone: "
						+ cliente.getTelefoneCliente() + "\n\nDADOS DO DESTINO:" + "\nID: " + destino.getIdDestino()
						+ "\nLocal: " + destino.getLocalDestino() + "\nValor da passagem: " + destino.getValorDestino()
						+ Colors.BLUE.get() + "\n========================================\n" + Colors.RESET.get());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void atualizarReserva(Reserva reserva) {
		sql = "UPDATE reserva SET dataReserva = ?, statusReserva = ?, idCliente = ?, idDestino = ? WHERE idReserva = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			Timestamp sqlDataReserva = Timestamp.valueOf(reserva.getDataReserva());
			stmt.setTimestamp(1, sqlDataReserva);
			stmt.setString(2, reserva.getStatusReserva());
			stmt.setLong(3, reserva.getCliente().getIdCliente());
			stmt.setLong(4, reserva.getDestino().getIdDestino());
			stmt.setLong(5, reserva.getIdReserva());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deletarReserva(long idReserva) {
		sql = "DELETE FROM reserva WHERE idReserva = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, idReserva);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
