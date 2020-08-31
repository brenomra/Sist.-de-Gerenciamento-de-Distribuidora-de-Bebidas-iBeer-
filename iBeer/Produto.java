package iBeer;

public class Produto {
	//ATRIBUTOS DA CLASSE:
	private String nome;
	private int numero;
	private int quantidade;
	
	//CONSTRUTOR:
	public Produto(String nome, int numero, int quantidade) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.quantidade = quantidade;
	}
	public Produto() {
		super();
		this.nome = "";
		this.numero = 0;
		this.quantidade = 0;
	}

	//GETTERS+SETTERS:
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	//TOSTRING:
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", numero=" + numero + ", quantidade=" + quantidade + "]";
	}
	
}
