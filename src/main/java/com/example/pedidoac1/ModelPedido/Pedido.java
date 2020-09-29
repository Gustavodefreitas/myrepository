package com.example.pedidoac1.ModelPedido;
import java.util.Date;

public class Pedido {
    private int codigo;
    private double valor;
    private String descricao;
    private Date dataPedido;
    private String Cliente;



	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		Cliente = cliente;
	}
	@Override
	public String toString() {
		return "Pedido [Cliente=" + Cliente + ", codigo=" + codigo + ", dataPedido=" + dataPedido + ", descricao="
				+ descricao + ", valor=" + valor + "]";
	}
    
    
}
