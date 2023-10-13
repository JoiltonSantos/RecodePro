package com.migrar.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.migrar.dao.DestinoDAO;
import com.migrar.database.DatabaseConnection;
import com.migrar.model.Destino;
import com.migrar.utils.Colors;

public class DestinoIO {
	static Connection connection = DatabaseConnection.createConnection();
	static DestinoDAO destinoDAO = new DestinoDAO(connection);

	public static int SubMenuDestino(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println(Colors.YELLOW.get() + "================DESTINO=================\n" + Colors.RESET.get()
					+ "1 - Cadastrar destino\n" + "2 - Listar destinos\n" + "3 - Atualizar destino\n"
					+ "4 - Deletar destino" + "\n5 - Retornar ao menu principal" + Colors.YELLOW.get()
					+ "\n========================================" + Colors.RESET.get());
			System.out.print("Informe a opção desejada: ");
			option = scanner.nextInt();
			System.out.println(Colors.YELLOW.get() + "========================================\n" + Colors.RESET.get());
			switch (option) {
			case 1:
				scanner.nextLine();
				Destino destino = new Destino();
				System.out.print("Informe o local a ser registrado: ");
				destino.setLocalDestino(scanner.nextLine());
				System.out.print("Preço do destino: ");
				destino.setValorDestino(scanner.nextFloat());

				destinoDAO.criarDestino(destino);
				break;
			case 2:
				destinoDAO.listarDestinos();
				break;
			case 3:
				Destino destinoAtualizado = new Destino();
				System.out.print("Digite o ID do destino a ser atualizado: ");
				destinoAtualizado.setIdDestino(scanner.nextLong());
				scanner.nextLine();
				System.out.print("Local de destino: ");
				destinoAtualizado.setLocalDestino(scanner.nextLine());
				System.out.print("Preço do destino: ");
				destinoAtualizado.setValorDestino(scanner.nextFloat());

				destinoDAO.atualizarDestino(destinoAtualizado);
				break;
			case 4:
				System.out.print("Digite o ID do Destino a ser DELETADO: ");
				long idDestino = scanner.nextLong();
				destinoDAO.deletarDestino(idDestino);
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
