package com.migrar.menu;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.migrar.model.Reserva;
import com.migrar.utils.Colors;
import com.migrar.dao.ReservaDAO;
import com.migrar.database.DatabaseConnection;
import com.migrar.model.Cliente;
import com.migrar.model.Destino;

public class ReservaIO {
	static Connection connection = DatabaseConnection.createConnection();
	static ReservaDAO reservaDAO = new ReservaDAO(connection);

	public static int SubMenuReserva(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		do {
			System.out.println(Colors.YELLOW.get() + "================RESERVA=================\n" + Colors.RESET.get()
					+ "1 - Registrar reserva\n" + "2 - Listar reservas\n" + "3 - Atualizar reserva\n"
					+ "4 - Deletar reserva" + "\n5 - Retornar ao menu principal" + Colors.YELLOW.get()
					+ "\n========================================" + Colors.RESET.get());
			System.out.print("Informe a opção desejada: ");
			option = scanner.nextInt();
			System.out.println(Colors.YELLOW.get() + "========================================\n" + Colors.RESET.get());
			switch (option) {
			case 1:
				scanner.nextLine();
				Reserva reserva = new Reserva();
				System.out.print("Digite o horario da reserva no formato dd/MM/yyyy HH:mm:ss ");
				String dataEhoraReserva = scanner.nextLine();
				reserva.setDataReserva(LocalDateTime.parse(dataEhoraReserva, formatter));
				System.out.print("Informe o status da reserva: ");
				reserva.setStatusReserva(scanner.nextLine());
				System.out.print("Digite o ID do Cliente: ");
				Cliente clienteReserva = new Cliente();
				clienteReserva.setIdCliente(scanner.nextLong());
				reserva.setCliente(clienteReserva);
				System.out.print("Digite o ID do Destino: ");
				Destino destinoReserva = new Destino();
				destinoReserva.setIdDestino(scanner.nextLong());
				reserva.setDestino(destinoReserva);

				reservaDAO.criarReserva(reserva);
				break;
			case 2:

				reservaDAO.listarReservas();
				break;
			case 3:
				Reserva reservaAtualizada = new Reserva();
				System.out.print("Digite o ID do Reserva a ser atualizada: ");
				reservaAtualizada.setIdReserva(scanner.nextLong());
				scanner.nextLine();
				System.out.print("Digite o horario da reserva no formato dd/MM/yyyy HH:mm:ss ");
				String dataEhoraReservaAtualizada = scanner.nextLine();
				reservaAtualizada.setDataReserva(LocalDateTime.parse(dataEhoraReservaAtualizada, formatter));
				System.out.print("Informe o status da reserva: ");
				reservaAtualizada.setStatusReserva(scanner.nextLine());
				System.out.print("Digite o ID do Cliente: ");
				Cliente clienteReservaAtualizado = new Cliente();
				clienteReservaAtualizado.setIdCliente(scanner.nextLong());
				reservaAtualizada.setCliente(clienteReservaAtualizado);
				System.out.print("Digite o ID do Destino: ");
				Destino destinoReservaAtualizado = new Destino();
				destinoReservaAtualizado.setIdDestino(scanner.nextLong());
				reservaAtualizada.setDestino(destinoReservaAtualizado);

				reservaDAO.atualizarReserva(reservaAtualizada);
				break;
			case 4:
				System.out.print("Digite o ID da Reserva a ser DELETADO: ");
				int idReserva = scanner.nextInt();
				reservaDAO.deletarReserva(idReserva);
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
