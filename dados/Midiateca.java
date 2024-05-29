package dados;

import java.util.ArrayList;
import java.util.Scanner;

public class Midiateca implements Iterador {

	private int contador;

	private Midia[] midia;

	private ArrayList<Midia> listaMidia = new ArrayList<>();

	private ArrayList<Musica> listaMusica = new ArrayList<>();

	private ArrayList<Video> listaVideo = new ArrayList<>();

	public Midiateca() {

	}

	public boolean cadastraMidiaMusica() {
		Scanner in = new Scanner(System.in);
		int codigo = in.nextInt();
		int ano = in.nextInt();
		double duracao = in.nextDouble();
		String titulo = in.nextLine();
		String valorCategoria = in.nextLine();
		Categoria categoria = Categoria.valueOf(valorCategoria);
		Musica m = new Musica(codigo, titulo, ano, categoria, duracao);
		for (Musica musicaM : listaMusica) {
			if (m.getCodigo() != musicaM.getCodigo()) {
				listaMusica.add(m);
				listaMidia.add(m);
				System.out.println("  1: " + codigo + " ," + titulo + " ," + ano + " ," + categoria + " ," + duracao);
				return true;
			} else {
				System.out.println(" 1:Erro- Vídeo com codigo repetido: " + codigo);
			}
		}
		in.close();
		return false;
	}

	public boolean cadastraMidiaVideo() {
		Scanner in = new Scanner(System.in);
		int codigo = in.nextInt();
		int ano = in.nextInt();
		int qualidade = in.nextInt();
		String titulo = in.nextLine();
		String valorCategoria = in.nextLine();
		Categoria categoria = Categoria.valueOf(valorCategoria);
		Video v = new Video(codigo, titulo, ano, categoria, qualidade);
		for (Video videoV : listaVideo) {
			if (v.getCodigo() != videoV.getCodigo()) {
				listaMidia.add(v);
				listaVideo.add(v);
				System.out.println(" 1: " + codigo + " ," + titulo + " ," + ano + " ," + categoria + " ," + qualidade);
				return false;
			} else {
				System.out.println(" 1:Erro- Música com codigo repetido: " + codigo);
			}
		}
		in.close();
		return true;
	}

	public Midia[] adiconandoNoArray() {
		int tamanho = listaMidia.size();
		midia = new Midia[tamanho];
		int i = 0;
		while (!listaMidia.isEmpty()) {
			midia[i] = listaMidia.get(i);
			i++;
		}
		return midia;
	}

	public Midia consultaPorCodigo() {
		Scanner in = new Scanner(System.in);
		System.out.println("Qual o código da mídia a ser consultada? :");
		int codigo = in.nextInt();
		int contIndex = 0;
		for (int i = 0; i < midia.length; i++) {
			if (midia[i].getCodigo() == codigo) {
				contIndex = midia.length - i;
			} else {
				contIndex = 100;
			}
		}
		if (contIndex == 100) {
			return null;
		} else {
			return midia[contIndex];
		}
	}

	public ArrayList<Midia> consultaPorCategoria() {
		Scanner in = new Scanner(System.in);
		System.out.println("Qual o categoria da mídia a ser consultada? :");
		String cate = in.nextLine();
		Categoria categoria = Categoria.valueOf(cate);
		ArrayList<Midia> resultado = new ArrayList<>();
		for (Midia midia : listaMidia) {
			if (midia.getCategoria().equals(categoria)) {
				resultado.add(midia);
			}
		}
		return resultado;
	}

	public boolean removeMidia() {
		Scanner in = new Scanner(System.in);
		System.out.println("Qual o código da mídia a ser removida? :");
		int remover = in.nextInt();
		int cont = 0;
		for (Midia m : listaMidia) {
			if (remover != m.getCodigo()) {
				cont++;
			} else {
				listaMidia.remove(cont);
			}
		}
		in.close();
		return true;
	}

	public ArrayList<Video> qualidadeVideo() {
		Scanner in = new Scanner(System.in);
		ArrayList<Video> resultado = new ArrayList<>();
		System.out.println("Qual a qualidade dos vídeos a serem mostradas? :");
		int qualidade = in.nextInt();
		if (!listaVideo.isEmpty()) {
			for (Video v : listaVideo) {
				if (v.getQualidade() == qualidade) {
					resultado.add(v);
				}
			}
		} else {
			return null;
		}
		in.close();
		return resultado;
	}

	public void maiorDuracaoMusica() {
		int index = -1;
		double maxDuracao = 0.1;
		if (!listaMusica.isEmpty()) {
			for (int i = 0; i < listaMusica.size(); i++) {
				Musica m = listaMusica.get(i);
				if (m.getDuracao() > maxDuracao) {
					maxDuracao = m.getDuracao();
					index = i;
				}
			}
			if (index != -1) {
				Musica maior = listaMusica.get(index);
				System.out.println(" 6: " + maior.getTitulo() + " ," + maior.getDuracao());
			} else {
				System.out.println("Nenhuma música encontrada.");
			}
		}
	}

		/**
		 * @see dados.Iterador#reset()
		 */
		public void reset() {

		}

		/**
		 * @see dados.Iterador#hasNext()
		 */
		public boolean hasNext() {
			return false;
		}

		/**
		 * @see dados.Iterador#next()
		 */
		public Object next() {
			return null;
		}
	}


