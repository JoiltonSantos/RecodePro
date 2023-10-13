package com.migrar.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.migrar.dao.ClienteDAO;
import com.migrar.database.DatabaseConnection;
import com.migrar.model.Cliente;
import com.migrar.utils.Colors;

public class ClienteIO {
	static Connection connection = DatabaseConnection.createConnection();
	static ClienteDAO clienteDAO = new ClienteDAO(connection);

	public static int SubMenuCliente(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println(Colors.YELLOW.get() + "===============CLIENTE==================\n" + Colors.RESET.get()
					+ "1 - Cadastrar cliente\n" + "2 - Listar clientes\n" + "3 - Atualizar cliente\n"
					+ "4 - Deletar cliente" + "\n5 - Retornar ao menu principal" + Colors.YELLOW.get()
					+ "\n========================================" + Colors.RESET.get());
			System.out.print("Informe a opção desejada: ");
			option = scanner.nextInt();
			System.out.println(Colors.YELLOW.get() + "========================================\n" + Colors.RESET.get());
			switch (option) {
			case 1:
				scanner.nextLine();
				Cliente cliente = new Cliente();
				System.out.print("Nome Completo: ");
				cliente.setNomeCliente(scanner.nextLine());
				System.out.print("CPF: ");
				cliente.setCpfCliente(scanner.nextLine().trim());
				System.out.print("E-MAIL: ");
				cliente.setEmailCliente(scanner.nextLine());
				System.out.print("Telefone: ");
				cliente.setTelefoneCliente(scanner.next().trim());

				clienteDAO.criarCliente(cliente);
				break;
			case 2:
				clienteDAO.listarClientes();
				break;
			case 3:
				Cliente clienteAtualizado = new Cliente();
				System.out.print("Digite o ID do cliente a ser atualizado: ");
				clienteAtualizado.setIdCliente(scanner.nextLong());
				scanner.nextLine();
				System.out.print("Nome Completo: ");
				clienteAtualizado.setNomeCliente(scanner.nextLine());
				System.out.print("CPF: ");
				clienteAtualizado.setCpfCliente(scanner.nextLine().trim());
				System.out.print("E-MAIL: ");
				clienteAtualizado.setEmailCliente(scanner.nextLine());
				System.out.print("Telefone: ");
				clienteAtualizado.setTelefoneCliente(scanner.next().trim());

				clienteDAO.atualizarCliente(clienteAtualizado);
				break;
			case 4:
				System.out.print("Digite o ID do Cliente a ser DELETADO: ");
				long idCliente = scanner.nextLong();
				clienteDAO.deletarCliente(idCliente);

				break;
			case 5:
				System.out.println(Colors.GREEN.get() + "Retornando ao menu..." + Colors.RESET.get());
				break;
			default:
				System.out.println(Colors.YELLOW.get() + "Digite uma opcao valida" + Colors.RESET.get());

			}

		} while (option != 5);

		return option;
	}
}
