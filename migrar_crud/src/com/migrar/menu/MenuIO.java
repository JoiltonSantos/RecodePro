package com.migrar.menu;

import java.util.Scanner;

import com.migrar.utils.Colors;

public class MenuIO {
	public static int menu(Scanner scanner) {
		System.out.println(Colors.YELLOW.get() + "=================MENU===================\n" + Colors.RESET.get()
				+ "1 - Acessar clientes\n" + "2 - Acessar destinos de viagens\n" + "3 - Acessar reservas\n"
				+ "4 - Acessar contatos\n" + "5 - Sair" + Colors.YELLOW.get()
				+ "\n========================================" + Colors.RESET.get());
		System.out.print("Escolha uma opcao de 1 - 5: ");
		return scanner.nextInt();

	}
}
