package com.migrar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.migrar.model.Cliente;
import com.migrar.utils.Colors;

public class ClienteDAO {
	private static String sql;
	private final Connection connection;

	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}

	public void criarCliente(Cliente cliente) {
		sql = "INSERT INTO cliente (nomeCliente, emailCliente, cpfCliente, telefoneCliente) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getEmailCliente());
			stmt.setString(3, cliente.getCpfCliente());
			stmt.setString(4, cliente.getTelefoneCliente());
			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Cliente criado com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarClientes() {
		sql = "SELECT * FROM cliente";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(r.getLong("idCliente"));
				cliente.setNomeCliente(r.getString("nomeCliente"));
				cliente.setEmailCliente(r.getString("emailCliente"));
				cliente.setCpfCliente(r.getString("cpfCliente"));
				cliente.setTelefoneCliente(r.getString("telefoneCliente"));
				System.out.println("ID: " + cliente.getIdCliente() + "\nNome: " + cliente.getNomeCliente()
						+ "\nE-MAIL: " + cliente.getEmailCliente() + "\nCPF: " + cliente.getCpfCliente()
						+ "\nTelefone: " + cliente.getTelefoneCliente() + Colors.BLUE.get()
						+ "\n========================================\n" + Colors.RESET.get());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void atualizarCliente(Cliente cliente) {
		sql = "UPDATE cliente SET nomeCliente = ?, emailCliente = ?, cpfCliente = ?, telefoneCliente = ? WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getEmailCliente());
			stmt.setString(3, cliente.getCpfCliente());
			stmt.setString(4, cliente.getTelefoneCliente());
			stmt.setLong(5, cliente.getIdCliente());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deletarCliente(long idCliente) {
		sql = "DELETE FROM cliente WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, idCliente);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
