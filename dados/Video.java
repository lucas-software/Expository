package dados;

public class Video extends Midia {

	private int qualidade;
	private double valorLocacao;

	public Video(int codigo, String titulo, int ano, Categoria categoria, int qualidade) {
        super(codigo,titulo,ano,categoria);
		this .qualidade = qualidade;
    }

	public int getQualidade(){
		return qualidade;
	}
	@Override
	public double calculaLocacao() {
		int anoMidia;
		anoMidia = super.getAno();
		if(anoMidia == 2024){
			valorLocacao = 20.00;
			return valorLocacao;
		}else if(anoMidia >= 2000 && anoMidia <= 2023){
			valorLocacao = 15.00;
			return valorLocacao;
		}else{
			valorLocacao = 10.00;
			return valorLocacao;
		}
	}
}
