package iBeer;

public class Pedido {
private int numero;
private String cliente;
private int quantidadeDoProduto1;
private int quantidadeDoProduto2;
private int quantidadeDoProduto3;
private String data;

//CONSTRUTORES:
public Pedido(int numero, String cliente, int quantidadeDoProduto1, int quantidadeDoProduto2, int quantidadeDoProduto3,
		String data) {
	super();
	this.numero = numero;
	this.cliente = cliente;
	this.quantidadeDoProduto1 = quantidadeDoProduto1;
	this.quantidadeDoProduto2 = quantidadeDoProduto2;
	this.quantidadeDoProduto3 = quantidadeDoProduto3;
	this.data = data;
}
public Pedido() {
	this.numero = 0;
	this.cliente = "";
	this.quantidadeDoProduto1 = 0;
	this.quantidadeDoProduto2 = 0;
	this.quantidadeDoProduto3 = 0;
	this.data = "";
}

//GETTERS+SETTERS:
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public String getCliente() {
	return cliente;
}
public void setCliente(String cliente) {
	this.cliente = cliente;
}
public int getQuantidadeDoProduto1() {
	return quantidadeDoProduto1;
}
public void setQuantidadeDoProduto1(int quantidadeDoProduto1) {
	this.quantidadeDoProduto1 = quantidadeDoProduto1;
}
public int getQuantidadeDoProduto2() {
	return quantidadeDoProduto2;
}
public void setQuantidadeDoProduto2(int quantidadeDoProduto2) {
	this.quantidadeDoProduto2 = quantidadeDoProduto2;
}
public int getQuantidadeDoProduto3() {
	return quantidadeDoProduto3;
}
public void setQuantidadeDoProduto3(int quantidadeDoProduto3) {
	this.quantidadeDoProduto3 = quantidadeDoProduto3;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}

//TOSTRING
@Override
public String toString() {
	return "Pedido [numero=" + numero + ", cliente=" + cliente + ", quantidadeDoProduto1=" + quantidadeDoProduto1
			+ ", quantidadeDoProduto2=" + quantidadeDoProduto2 + ", quantidadeDoProduto3=" + quantidadeDoProduto3
			+ ", data=" + data + "]";
}

}
