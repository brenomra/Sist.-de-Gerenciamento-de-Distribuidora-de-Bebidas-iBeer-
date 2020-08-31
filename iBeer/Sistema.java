package iBeer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class Sistema {
	private Scanner ler = new Scanner(System.in);
	
	//CADASTRAR CLIENTE:
	public void cadastraCliente() throws FileNotFoundException, IOException
	{
		Cliente cliente = new Cliente();
		long n;
		int tamReg = 3*2*30;
		RandomAccessFile arqClientes = new RandomAccessFile("Clientes.dat", "rw");
		String nome;
		arqClientes.seek(arqClientes.length());
		n = (arqClientes.length() / tamReg)+1;
		System.out.printf("Informe o nome do Cliente, FIM para encerrar\n");
		nome = ler.nextLine();
		
		while (!nome.equalsIgnoreCase("FIM"))
		{
			System.out.printf("%do. registro-------------------------------\n", n);
			cliente.setNome(nome);
			System.out.println("Informe telefone do "+nome);
			cliente.setTelefone(ler.nextLine());
			System.out.println("Informe endereço do "+nome);
			cliente.setEndereco(ler.nextLine());		
			gravarString(arqClientes, cliente.getNome(), 30);
			gravarString(arqClientes, cliente.getTelefone(), 30);
		    gravarString(arqClientes, cliente.getEndereco(), 30);
		    n=n+1;
		    System.out.printf("\n");
			System.out.printf("Informe o nome do cliente, FIM para encerrar:\n");
			nome = ler.nextLine();
		}
		arqClientes.close();
	 }
	
	//MOSTRA CLIENTES:
	public void mostraClientes() throws IOException{
	Cliente cliente = new Cliente();
	try {
		int tamReg = 3*2*30;
		RandomAccessFile arqClientes = new RandomAccessFile("Clientes.dat", "rw");
		System.out.printf("Reg \t\t\t     Nome                         Telefone                   Endereço\n");
		System.out.printf("-------------------------------------------------------------------------------------------------------------------------------\n");
		int i;
		long n = (arqClientes.length()/tamReg);
		for (i=1; i<=n; i++)
		{
			cliente.setNome(lerString(arqClientes,30));
			cliente.setTelefone(lerString(arqClientes,30));
			cliente.setEndereco(lerString(arqClientes,30));
				System.out.printf("%3d %30s %30s %30s \n", i, cliente.getNome(), cliente.getTelefone(), cliente.getEndereco());
		}
		System.out.printf("-------------------------------------------------------------------------------------------------------------------------------\n");
		arqClientes.close();
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo não encontrado: %s.\n", e.getMessage());
		}
	}
	
	//CADASTRAR FORNECEDORES:
	public void cadastraFonecedor() throws FileNotFoundException, IOException
	{
		Fornecedor fornecedor = new Fornecedor();
		long n;
		int tamReg = 3*2*30;
		RandomAccessFile arqFornecedores = new RandomAccessFile("Fornecedores.dat", "rw");
		String nome;
		arqFornecedores.seek(arqFornecedores.length());
		n = (arqFornecedores.length() / tamReg)+1;
		System.out.printf("Informe o nome do fornecedor, FIM para encerrar\n");
		nome = ler.nextLine();
		
		while (!nome.equalsIgnoreCase("FIM"))
		{
			System.out.printf("%do. registro-------------------------------\n", n);
			fornecedor.setNome(nome);
			System.out.println("Informe telefone do "+nome);
			fornecedor.setTelefone(ler.nextLine());
			System.out.println("Informe endereço do "+nome);
			fornecedor.setEndereco(ler.nextLine());		
			gravarString(arqFornecedores, fornecedor.getNome(), 30);
			gravarString(arqFornecedores, fornecedor.getTelefone(), 30);
		    gravarString(arqFornecedores, fornecedor.getEndereco(), 30);
		    n=n+1;
		    System.out.printf("\n");
			System.out.printf("Informe o nome do fornecedor, FIM para encerrar:\n");
			nome = ler.nextLine();
		}
		arqFornecedores.close();
	}
	
	//FORMATA STRING:
	public void gravarString(RandomAccessFile arq, String s, int tam) throws IOException 
	{
	    StringBuilder result = new StringBuilder(s);
	    result.setLength(tam);
	    arq.writeChars(result.toString());
	 }
	
	//MOSTRAR FORNECEDORES
	public void mostraFornecedor() throws IOException
	{
		Fornecedor fornecedor = new Fornecedor();
		try {
			int tamReg = 3*2*30;
			RandomAccessFile arqFornecedores = new RandomAccessFile("Fornecedores.dat", "rw");
			System.out.printf("Reg\t\t\t      Nome                      Telefone                    Endereço\n");
			System.out.printf("-------------------------------------------------------------------------------------------------------------------------------\n");
			int i;
			long n = (arqFornecedores.length()/tamReg);
			for (i=1; i<=n; i++)
			{
				fornecedor.setNome(lerString(arqFornecedores,30));
				fornecedor.setTelefone(lerString(arqFornecedores,30));
				fornecedor.setEndereco(lerString(arqFornecedores,30));
				System.out.printf("%3d %30s %30s %30s \n", i, fornecedor.getNome(), fornecedor.getTelefone(), fornecedor.getEndereco());
			}
			System.out.printf("-------------------------------------------------------------------------------------------------------------------------------\n");
			arqFornecedores.close();
			} catch (FileNotFoundException e) {
				System.err.printf("Arquivo não encontrado: %s.\n", e.getMessage());
			}
	}
	
	//LE STRING FORMATADA
	public String lerString(RandomAccessFile arq, int tam) throws IOException 
	{
		char result[] = new char[tam];
		for (int i=0; i<tam; i++) 
		{
			result[i] = arq.readChar();
		}
		return(new String(result).replaceAll(String.valueOf((char) 0), ""));
	}
	
	//CADASTRAR PRODUTO:
	public void cadastraProduto() throws FileNotFoundException, IOException
	{
		Scanner leitura = new Scanner(System.in);
		Produto produto = new Produto();
		long n;
		int tamReg = 1*2*30+2*4; //1 STRING (NOME) COM 30 CARACTERES, CADA UM COM 2 BYTES
							     //2 INT (QUANTIDADE E NUMERO) CADA UM COM 4 BYTES
		RandomAccessFile arqProdutos = new RandomAccessFile("Produto.dat", "rw");
		int numero;
		arqProdutos.seek(arqProdutos.length());
		n = (arqProdutos.length() / tamReg)+1;
		System.out.printf("Gostaria de adicionar algum produto?\n"
					+ "Informe o numero do produto, 0 para encerrar\n");
		numero = Integer.parseInt(leitura.next());
			
		while (numero!=0)
		{
			System.out.printf("%do. registro-------------------------------\n", n);
			produto.setNumero(numero);
			System.out.println("Informe o nome do produto "+numero);
			produto.setNome(ler.nextLine());
			System.out.println("Informe a quantidade disponivel do produto "+numero);
			produto.setQuantidade(Integer.parseInt(leitura.next()));		
			    
			arqProdutos.writeInt(numero);
			gravarString(arqProdutos, produto.getNome(), 30);
			arqProdutos.writeInt(produto.getQuantidade());
				
			n=n+1;
			System.out.printf("\n");
			System.out.printf("Informe o numero do produto, 0 para encerrar\n");
			numero = Integer.parseInt(leitura.next());
		}
		arqProdutos.close();
	}
	
	//MOSTRAR PRODUTOS
	public void mostraProdutos() throws IOException
	{
		Produto produtos = new Produto();
		try {
				int tamReg = 1*2*30+2*4;
				RandomAccessFile arqProdutos = new RandomAccessFile("Produto.dat", "rw");
				System.out.printf("Reg Numero                       Nome                            Quantidade\n");
				System.out.printf("-------------------------------------------------------------------------------------------------------------------------------\n");
				int i;
				long n = (arqProdutos.length()/tamReg);
				for (i=1; i<=n; i++)
				{
					produtos.setNumero(arqProdutos.readInt());
					produtos.setNome(lerString(arqProdutos,30));
					produtos.setQuantidade(arqProdutos.readInt());
					System.out.printf("%3d %3d %30s                               %3d \n", i, produtos.getNumero(), produtos.getNome(), produtos.getQuantidade());
				}
				System.out.printf("-------------------------------------------------------------------------------------------------------------------------------\n");
				arqProdutos.close();
			} catch (FileNotFoundException e) {
				System.err.printf("Arquivo não encontrado: %s.\n", e.getMessage());
			}
	}

	//ALTERAR QUANTIDADE DE PRODUTO
	public void alteraProdutos() throws FileNotFoundException, IOException 
	{
		Scanner ler = new Scanner(System.in);
		Produto produto = new Produto();
		int numero,quantidade,contReg=1;
		long n=0;
		int tamReg = 1*2*30+2*4;
		RandomAccessFile arqProdutos = new RandomAccessFile("Produto.dat", "rw");
		boolean encontrou=false;
		n = (arqProdutos.length() / tamReg); // calcula o número de registros do arquivo (sizefile)

		if(n!=0)
		{
			System.out.printf("Informe o numero do produto que os dados serão atualizados, -1 para encerrar:\n");
			numero=Integer.parseInt(ler.nextLine());

			while (numero!=-1) 
			{
				//PROCURA NO ARQUIVO ENQUANTO NÃO CHEGA NO FINAL DOS REGISTROS E ENQUANTO O NUMERO DIGITADO FOR DIFERENTE DO NUMERO QUE ESTÁ NO ARQUIVO
				while(contReg<=n && (arqProdutos.readInt()!=numero))
				{
					arqProdutos.seek(tamReg*(contReg)); // posiciona o ponteiro de posição no próximo registro do arquivo
					contReg++;
				}
					
				if(contReg<=n)
				{
				// leitura dos novos dados do registro a ser alterado
					System.out.printf("Informe a quantidade de cerveja do tipo escolhido:\n");
					int qt = Integer.parseInt(ler.nextLine());
					produto.setNumero(numero);
					produto.setNome(lerString(arqProdutos,30));
					produto.setQuantidade(qt);
						
					arqProdutos.seek(tamReg*(contReg-1)); // posiciona o ponteiro de posição no registro do arquivo a ser alterado
						
					arqProdutos.writeInt(numero);
					gravarString(arqProdutos, produto.getNome(), 30);
					arqProdutos.writeInt(produto.getQuantidade());
					}
				else
				{
					System.out.println("Produto "+numero+" não foi encontrado!");
				}
				
				arqProdutos.seek(0);// posiciona o ponteiro no início do arquivo

				System.out.printf("Informe o numero do produto que os dados serão atualizados, -1 para encerrar:\n");
				numero=Integer.parseInt(ler.nextLine());
				}
		}
		
		else
		{
			System.out.println("Arquivo vazio! Fim do programa!");
		}
			arqProdutos.close();
	}
	
	//CADASTRAR PEDIDO
	public void cadastraPedido() throws FileNotFoundException, IOException
	{
		Scanner leitura = new Scanner(System.in);
		Pedido pedido = new Pedido();
		boolean clienteEncontrado=false;
		int tamReg = 2*2*30+4*4; //1 STRING (NOME, DATA) COM 30 CARACTERES, CADA UM COM 2 BYTES
								 //4 INT (NUMERO, QUANTIDADEPRODUTO1, QUANTIDADEPRODUTO2, QUANTIDADEPRODUTO3) CADA UM COM 4 BYTES
		int tamReg2 = 3*2*30; //TAMANHO DO ARQUIVO DE CLIENTES
		
		RandomAccessFile arqPedido = new RandomAccessFile("Pedido.dat", "rw");
		
		String cliente;
		arqPedido.seek(arqPedido.length());
		
		System.out.printf("Gostaria de adicionar algum pedido? Se sim, informe o nome do cliente cadastrado ou FIM para encerrar\n");
		
		cliente = leitura.next();
		Cliente objCliente = new Cliente();
		try {
				RandomAccessFile arqClientes = new RandomAccessFile("Clientes.dat", "rw");
				int i;
				long quant = (arqClientes.length()/tamReg2);
				for (i=1; i<=quant; i++)
					{
					objCliente.setNome(lerString(arqClientes,30));
					objCliente.setTelefone(lerString(arqClientes,30));
					objCliente.setEndereco(lerString(arqClientes,30));
					if(objCliente.getNome().equalsIgnoreCase(cliente)) 
					{						
						System.out.printf("%3d %30s %30s %30s \n", i, objCliente.getNome(), objCliente.getTelefone(), objCliente.getEndereco());
						if(objCliente.getNome().equalsIgnoreCase(cliente))
						{
							clienteEncontrado=true;
						}
					}
				}
			arqClientes.close();
			} catch (FileNotFoundException e) {
				System.err.printf("Arquivo não encontrado: %s.\n", e.getMessage());
			}
		
		if (clienteEncontrado)
		{
			while (!cliente.equalsIgnoreCase("FIM"))
			{
				pedido.setCliente(cliente);
				System.out.println("Informe quantos pedidos do PRODUTO 1 ");
				pedido.setQuantidadeDoProduto1(Integer.parseInt(leitura.next()));
				System.out.println("Informe quantos pedidos do PRODUTO 2 ");
				pedido.setQuantidadeDoProduto2(Integer.parseInt(leitura.next()));
				System.out.println("Informe quantos pedidos do PRODUTO 3 ");
				pedido.setQuantidadeDoProduto3(Integer.parseInt(leitura.next()));
				System.out.println("Informe a data (DD/MM/AAAA)");
				pedido.setData(leitura.next());
				System.out.println("Informe o numero do pedido ");
				pedido.setNumero(Integer.parseInt(leitura.next()));
			    
				arqPedido.writeInt(pedido.getNumero());
				gravarString(arqPedido, pedido.getCliente(), 30);
				arqPedido.writeInt(pedido.getQuantidadeDoProduto1());
				arqPedido.writeInt(pedido.getQuantidadeDoProduto2());
				arqPedido.writeInt(pedido.getQuantidadeDoProduto3());
				gravarString(arqPedido, pedido.getData(), 30);
				
			    System.out.printf("\n");
			    System.out.printf("Gostaria de adicionar algum pedido?\n"
						+ "Informe o nome do cliente, FIM para encerrar\n");
				cliente = leitura.next();
			}
		}
		
		else
		{
			System.out.println("Cliente não encontrado");
		}
		
		arqPedido.close();
	}
		
	//MOSTRAR PEDIDO
	public void mostraPedido() throws IOException
	{
		Pedido pedido = new Pedido();
		try {
				int tamReg = 2*2*30+4*4; //1 STRING (NOME, DATA) COM 30 CARACTERES, CADA UM COM 2 BYTES
				 //4 INT (NUMERO, QUANTIDADEPRODUTO1, QUANTIDADEPRODUTO2, QUANTIDADEPRODUTO3) CADA UM COM 4 BYTES
				RandomAccessFile arqPedido = new RandomAccessFile("Pedido.dat", "rw");
				System.out.println("No \t\t\t     Nome    P1   P2   P3\t\t         DATA");
				System.out.println("--------------------------------------------------------------------------------------------");
				int i;
				long n = (arqPedido.length()/tamReg);
				
				for (i=1; i<=n; i++)
				{
					pedido.setNumero(arqPedido.readInt());
					pedido.setCliente(lerString(arqPedido,30));
					pedido.setQuantidadeDoProduto1(arqPedido.readInt());
					pedido.setQuantidadeDoProduto2(arqPedido.readInt());
					pedido.setQuantidadeDoProduto3(arqPedido.readInt());
					pedido.setData(lerString(arqPedido,30));
					System.out.printf("%3d %30s %3d  %3d   %3d %30s\n", pedido.getNumero(), pedido.getCliente(), pedido.getQuantidadeDoProduto1(), pedido.getQuantidadeDoProduto2(), pedido.getQuantidadeDoProduto3(), pedido.getData());
				}
				System.out.println("--------------------------------------------------------------------------------------------");
				arqPedido.close();
			} catch (FileNotFoundException e) {
				System.err.printf("Arquivo não encontrado: %s. \n", e.getMessage());
			}	
		}
		
	//EMITIR NOTA FISCAL
	public void emiteNota() throws FileNotFoundException, IOException
	{
		Pedido pedido = new Pedido();
		int numero,cont=1;
		long n=0;
		int tamReg = 2*2*30+4*4;;
		RandomAccessFile arqPedido = new RandomAccessFile("Pedido.dat", "rw");
		boolean encontrou=false;
		n = (arqPedido.length() / tamReg); // calcula o número de registros do arquivo (sizefile)

		if(n!=0)
		{
			System.out.printf("Informe o numero do pedido para emitir a nota fiscal, -1 para encerrar:\n");
			numero=Integer.parseInt(ler.nextLine());

			while (numero!=-1) 
			{
				while(cont<=n && (arqPedido.readInt()!=numero))
				{
					arqPedido.seek(tamReg*(cont)); // posiciona o ponteiro de posição no próximo registro do arquivo
					cont++;
				}
				if(cont<=n)
				{
					// EMITIR NOTA FISCAL
					System.out.println("NOTA FISCAL ENVIADA PARA O TELEFONE DO CLIENTE DO PEDIDO "+numero);
				}
				else
				{
					System.out.println("Pedido numero "+numero+" não foi encontrado!");
				}
				arqPedido.seek(0); // posiciona o ponteiro no início do arquivo
				cont=0;

				System.out.printf("Informe o numero do pedido para emitir a nota fiscal, -1 para encerrar:\n");
				numero=Integer.parseInt(ler.nextLine());
				}
		}
		else
		{
			System.out.println("Arquivo vazio! Fim do programa!");
		}
		arqPedido.close();
	}
}
