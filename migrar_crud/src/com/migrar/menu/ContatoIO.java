package com.migrar.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.migrar.dao.ContatoDAO;
import com.migrar.database.DatabaseConnection;
import com.migrar.model.Contato;
import com.migrar.utils.Colors;

public class ContatoIO {
	static Connection connection = DatabaseConnection.createConnection();
	static ContatoDAO contatoDAO = new ContatoDAO(connection);

	public static int SubMenuContato(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println(Colors.YELLOW.get() + "===============CONTATO==================\n" + Colors.RESET.get()
					+ "1 - Registrar contato\n" + "2 - Listar contatos\n" + "3 - Atualizar contato\n"
					+ "4 - Deletar contato" + "\n5 - Retornar ao menu principal" + Colors.YELLOW.get()
					+ "\n========================================" + Colors.RESET.get());
			System.out.print("Informe a opção desejada: ");
			option = scanner.nextInt();
			System.out.println(Colors.YELLOW.get() + "========================================\n" + Colors.RESET.get());
			switch (option) {
			case 1:
				scanner.nextLine();
				Contato contato = new Contato();
				System.out.print("Nome Completo: ");
				contato.setNomeContato(scanner.nextLine());
				System.out.print("Mensagem: ");
				contato.setMensagemContato(scanner.nextLine().trim());
				System.out.print("E-MAIL: ");
				contato.setEmailContato(scanner.nextLine());
				System.out.print("Telefone: ");
				contato.setTelefoneContato(scanner.next().trim());

				contatoDAO.criarContato(contato);
				break;
			case 2:
				contatoDAO.listarContatos();
				break;
			case 3:
				Contato contatoAtualizado = new Contato();
				System.out.print("Digite o ID dos dados do contato a ser atualizado: ");
				contatoAtualizado.setIdContato(scanner.nextLong());
				scanner.nextLine();
				System.out.print("Nome Completo: ");
				contatoAtualizado.setNomeContato(scanner.nextLine());
				System.out.print("E-MAIL: ");
				contatoAtualizado.setEmailContato(scanner.nextLine());
				System.out.print("Telefone: ");
				contatoAtualizado.setTelefoneContato(scanner.next().trim());

				contatoDAO.atualizarContato(contatoAtualizado);
				break;
			case 4:
				System.out.print("Digite o ID do contato a ser DELETADO: ");
				long idContato = scanner.nextLong();
				contatoDAO.deletarContato(idContato);
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
