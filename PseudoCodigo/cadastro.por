programa
{
	inclua biblioteca Util
	
	funcao inicio()
	{
		inteiro menu, contadorClientes = 0, contadorDestinos = 0, contadorVetores = 0
		cadeia nomeCliente = "", clientesCadastrados[10], destino = "", destinosRegistrados[10]
		
		enquanto (verdadeiro) {
			limpa()
			escreva("=================== MENU =======================\n")
			escreva("1 - Cadastrar cliente\n")
			escreva("2 - Lista de clientes\n")
			escreva("3 - Definir destino\n")
			escreva("4 - Lista de destinos\n")
			escreva("================================================\n")
			escreva("Selecione uma opcao de 1 a 4: ")
			leia(menu)
			escolha (menu) {
				caso 1:
					limpa()
					escreva("============= CADASTRO DE CLIENTE ==============\n")
					escreva("Informe o nome a ser cadastrado: ")
					leia(nomeCliente)
					se (contadorClientes < Util.numero_elementos(clientesCadastrados)) {
		                    clientesCadastrados[contadorClientes] = nomeCliente
		               	contadorClientes++
		              	} senao {
		                   	escreva("Limite de clientes cadastrados atingido.\n")
		                   	Util.aguarde(2000)
		               }
					pare
				caso 2:
					limpa()
					escreva("============== LISTA DE CLIENTES ===============\n")
					para(contadorVetores = 0; contadorVetores < contadorClientes; contadorVetores++) {
						escreva("\tCliente ",contadorVetores + 1,":\t\t",clientesCadastrados[contadorVetores],"\n")
						Util.aguarde(350)
					}
					escreva("================================================\n")
					Util.aguarde(5000)
					pare
				caso 3:
					limpa()
		               escreva("============= REGISTRO DE DESTINO ==============\n")
		               escreva("Informe o nome do destino: ")
		               leia(destino)
		               se (contadorDestinos < Util.numero_elementos(destinosRegistrados)) {
		               	destinosRegistrados[contadorDestinos] = destino
		                    contadorDestinos++
		               } senao {
		                    escreva("Limite de destinos registrados atingido.\n")
		                    Util.aguarde(2000)
		               }
		               pare
				caso 4:
					limpa()
					escreva("============== LISTA DE DESTINOS ===============\n")
					para(contadorVetores = 0; contadorVetores < contadorDestinos; contadorVetores++) {
						escreva("\tDestino ",contadorVetores + 1,":\t\t",destinosRegistrados[contadorVetores],"\n")
						Util.aguarde(350)
					}
					escreva("================================================\n")
					Util.aguarde(5000)
					pare
				caso contrario:
					limpa()
					escreva("Valor invalido, tente novamente.")
					Util.aguarde(4000)
					pare
			}		
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1347; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {nomeCliente, 8, 9, 11}-{clientesCadastrados, 8, 27, 19};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */