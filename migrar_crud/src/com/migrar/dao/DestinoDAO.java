package com.migrar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.migrar.model.Destino;
import com.migrar.utils.Colors;

public class DestinoDAO {
	private static String sql;
	private final Connection connection;

	public DestinoDAO(Connection connection) {
		this.connection = connection;
	}

	public void criarDestino(Destino destino) {
		sql = "INSERT INTO destino (localDestino, valorDestino) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, destino.getLocalDestino());
			stmt.setFloat(2, destino.getValorDestino());
			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Destino criado com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarDestinos() {
		sql = "SELECT * FROM destino";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Destino destino = new Destino();
				destino.setIdDestino(r.getLong("idDestino"));
				destino.setLocalDestino(r.getString("localDestino"));
				destino.setValorDestino(r.getFloat("valorDestino"));
				System.out.println("ID: " + destino.getIdDestino() + "\nLocal: " + destino.getLocalDestino()
						+ "\nValor da passagem: " + destino.getValorDestino() + Colors.BLUE.get()
						+ "\n========================================\n" + Colors.RESET.get());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void atualizarDestino(Destino destino) {
		sql = "UPDATE destino SET localDestino = ?, valorDestino = ? WHERE idDestino = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, destino.getLocalDestino());
			stmt.setFloat(2, destino.getValorDestino());
			stmt.setLong(3, destino.getIdDestino());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deletarDestino(long idDestino) {
		sql = "DELETE FROM destino WHERE idDestino = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, idDestino);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
