package iBeer;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
public static void main(String[] args) throws IOException {
	int opcao=1;
	Scanner leitura = new Scanner(System.in);
	Sistema ibeer = new Sistema();
	System.out.println("Insira o usuário do Administrador:");
	String validacao = leitura.next();
	if (validacao.equalsIgnoreCase("ibeeradmin"))
	{
	Administrador admin = new Administrador("ibeeradmin","999999-9999","Rua da Empresa");
	System.out.println(admin.toString());
	while(opcao!=0)
	{
		System.out.println("*************** MENU ***************");
		System.out.println("1 - Gerenciar clientes ");
		System.out.println("2 - Gerenciar produtos ");
		System.out.println("3 - Gerenciar fornecedor ");
		System.out.println("4 - Gerenciar pedidos ");
		System.out.println("0 - Parar execução do programa");
		System.out.println("Escolha a opção: ");
		opcao = Integer.parseInt(leitura.next());
		
		switch(opcao)
		{
		case 1:
			System.out.println("Insira 1 ou 2\n1 - Cadastrar clientes\n"
											+ "2 - Mostrar clientes");
			int resposta1 = Integer.parseInt(leitura.next());
			if (resposta1 == 1)
			{
				ibeer.cadastraCliente();
			}
			else if (resposta1 == 2)
			{
				System.out.println("||||||||||||||||| CLIENTES CADASTRADOS |||||||||||||||||");
				ibeer.mostraClientes();
			}
			else
			{
				System.out.println("Opção inválida.");
			}
			break;
		case 2: 
			System.out.println("Insira 1, 2 ou 3 \n1 - Cadastrar Produtos\n"
					+ 							  "2 - Alterar quantidade no estoque de produtos\n"
					+ 							  "3 - Mostrar produtos");
			int resposta2 = Integer.parseInt(leitura.next());
			if (resposta2 == 1)
			{
				ibeer.cadastraProduto();
			}
			else if (resposta2 == 2)
			{
				ibeer.alteraProdutos();
			}
			else if (resposta2 == 3)
			{
				System.out.println("||||||||||||||||| PRODUTOS CADASTRADOS |||||||||||||||||");
				ibeer.mostraProdutos();
			}
			else
			{
				System.out.println("Opção inválida.");
			}
			break;
		case 3:
			System.out.println("Insira 1 ou 2\n1 - Cadastrar fornecedor\n"
					+ 						  "2 - Mostrar fornecedor");
			int resposta3 = Integer.parseInt(leitura.next());
			if (resposta3==1)
			{
				ibeer.cadastraFonecedor();
			}
			else if (resposta3==2)
			{
				System.out.println("||||||||||||||||| FORNECEDORES CADASTRADOS |||||||||||||||||");
				ibeer.mostraFornecedor();
			}
			else
			{
				System.out.println("Opção inválida.");
			}
			break;
		case 4:
			System.out.println("Insira 1, 2 ou 3 \n1 - Cadastrar pedidos\n" //CADASTRA PEDIDO MANUALMENTE
					+ 							  "2 - Mostrar pedidos\n"
					+ 							  "3 - Emitir nota fiscal de um pedido"); // MOSTRAR PEDIDO ESPECÍFICO REALIZADO E PAGO
			int resposta4 = Integer.parseInt(leitura.next());
			if (resposta4==1)
			{
				ibeer.cadastraPedido();
			}
			else if (resposta4==2)
			{
				System.out.println("||||||||||||||||| PEDIDOS CADASTRADOS |||||||||||||||||");
				ibeer.mostraPedido();
			}
			else if (resposta4==3)
			{
				ibeer.emiteNota();
			}
			else
			{
				System.out.println("Opção inválida.");
			}
			break;
		case 0:
			opcao=0;
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	}
	else
	{
		System.out.println("O usuário "+validacao+" não tem permissão de acesso ao sistema");
	}
}
}
