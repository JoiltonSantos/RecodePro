package com.migrar;

import java.util.Scanner;

import com.migrar.menu.ClienteIO;
import com.migrar.menu.ContatoIO;
import com.migrar.menu.DestinoIO;
import com.migrar.menu.MenuIO;
import com.migrar.menu.ReservaIO;
import com.migrar.utils.Colors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int option = 0;

		do {

			option = MenuIO.menu(scanner);

			switch (option) {
			case 1:
				ClienteIO.SubMenuCliente(scanner);
				break;
			case 2:
				DestinoIO.SubMenuDestino(scanner);
				break;
			case 3:
				ReservaIO.SubMenuReserva(scanner);
				break;
			case 4:
				ContatoIO.SubMenuContato(scanner);
				break;
			case 5:
				System.out.println(Colors.GREEN.get() + "Encerrado com sucesso." + Colors.RESET.get());
				break;
			default:
				System.out.println(Colors.YELLOW.get() + "Digite uma opcao valida!" + Colors.RESET.get());

			}

		} while (option != 5);
		scanner.close();

	}

}
