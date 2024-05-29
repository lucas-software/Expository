package dados;

import java.util.ArrayList;

public class Musica extends Midia {

	private double duracao;
	private double valorLocacao;

	public Musica(int codigo, String titulo, int ano, Categoria categoria, double duracao) {
		super(codigo,titulo,ano,categoria);
		this.duracao = duracao;
    }

	public double getDuracao() {
		return duracao;
	}

	public double calculaLocacao() {
		double valorMinuto;
		if(getCategoria().getNome().equals("Acao")){
			valorMinuto = 0.90;
			valorLocacao = valorMinuto*duracao;
			return valorLocacao;
		}else if(getCategoria().getNome().equals("Drama")){
			valorMinuto = 0.70;
			valorLocacao = valorMinuto*duracao;
			return valorLocacao;
		}else if(getCategoria().getNome().equals("Ficcao")){
			valorMinuto = 0.50;
			valorLocacao = valorMinuto*duracao;
			return valorLocacao;
		}else{
			valorMinuto = 0.30;
			valorLocacao = valorMinuto*duracao;
			return valorLocacao;
		}
	}
}
