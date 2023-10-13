package com.migrar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.migrar.model.Contato;
import com.migrar.utils.Colors;

public class ContatoDAO {
	private static String sql;
	private final Connection connection;

	public ContatoDAO(Connection connection) {
		this.connection = connection;
	}

	public void criarContato(Contato contato) {
		sql = "INSERT INTO contato (nomeContato, emailContato, telefoneContato, mensagemContato) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, contato.getNomeContato());
			stmt.setString(2, contato.getEmailContato());
			stmt.setString(3, contato.getTelefoneContato());
			stmt.setString(4, contato.getMensagemContato());
			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Contato criado com sucesso!" + Colors.GREEN.get());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarContatos() {
		sql = "SELECT * FROM contato";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Contato contato = new Contato();
				contato.setIdContato(r.getLong("idContato"));
				contato.setNomeContato(r.getString("nomeContato"));
				contato.setEmailContato(r.getString("emailContato"));
				contato.setTelefoneContato(r.getString("telefoneContato"));
				contato.setMensagemContato(r.getString("mensagemContato"));
				System.out.println("ID: " + contato.getIdContato() + "\nNome: " + contato.getNomeContato()
						+ "\nE-MAIL: " + contato.getEmailContato() + "\nTelefone: " + contato.getTelefoneContato()
						+ "\nMensagem: " + contato.getMensagemContato() + Colors.BLUE.get()
						+ "\n========================================\n" + Colors.RESET.get());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void atualizarContato(Contato contato) {
		sql = "UPDATE contato SET nomeContato = ?, emailContato = ?, telefoneContato = ? WHERE idContato = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, contato.getNomeContato());
			stmt.setString(2, contato.getEmailContato());
			stmt.setString(3, contato.getTelefoneContato());
			stmt.setLong(4, contato.getIdContato());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deletarContato(long idContato) {
		sql = "DELETE FROM contato WHERE idContato = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, idContato);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
