package app;

import dados.Midiateca;

public class ACMEMidia {

	private Midiateca midiateca;

	public ACMEMidia() {

	}

	public void executa() {
		midiateca.cadastraMidiaMusica();
		midiateca.cadastraMidiaVideo();
		midiateca.adiconandoNoArray();
		midiateca.consultaPorCategoria();
		midiateca.consultaPorCodigo();
		midiateca.maiorDuracaoMusica();
		midiateca.qualidadeVideo();
		midiateca.removeMidia();
	}

}
