package backend;

import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import java.net.URL;

public class Tabuleiro extends JPanel implements AcoesTabuleiro {

	/**
	 * partes do swing sairao na versao final e vao para as classes do front end
	 * 
	 */

	public static ArrayList<Celula> mapa = new ArrayList<>();
	public static ArrayList<Integer> minasMarcadas = new ArrayList<>();
	private ArrayList<Integer> posicaoBombas = new ArrayList<>();
	private ArrayList<Integer> adjacentes = new ArrayList<>();
	private int numBombas = 10;
	public static int bandeiras = 10;
	private int tamMapa = 100;
	private int tamLinha = 10;
	public static int bombasNoCampo = 10;
	private int totalAbertas = 0;

	// retirar depois(apenas testes, saira na versao final)

	Icon bomba = new ImageIcon("src\\texture_pack\\tnt.png");
	Icon terra = new ImageIcon("src\\texture_pack\\terra.jpeg");
	Icon grama = new ImageIcon("src\\texture_pack\\grama.jpeg");
	Icon bandeira = new ImageIcon("src\\texture_pack\\tocha_bandeira.png");

	public Tabuleiro() {

	}

	public Tabuleiro(GridLayout g) {
		super(g);
		criarCampo();
		adicionarCelulas();
	}

	Random aleatorio = new Random();

	// preencher o mapa
	public void criarCampo() {

		// gerar numeros aleatorios sem repeticao
		while (posicaoBombas.size() < numBombas) {
			int index = aleatorio.nextInt(100);
			if (!posicaoBombas.contains(index)) {
				posicaoBombas.add(index);
			}

		}

		for (int i = 0; i < tamMapa; i++) {
			if (posicaoBombas.contains(i)) {
				mapa.add(new Bomba(i));
				mapa.get(i).setIcon(grama);
			} else if (i % tamLinha == 0) {
				if (posicaoBombas.contains(i - tamLinha + 1) || posicaoBombas.contains(i - tamLinha)
						|| posicaoBombas.contains(i + tamLinha) || posicaoBombas.contains(i + tamLinha + 1)
						|| posicaoBombas.contains(i + 1)) {

					mapa.add(new CelulaAlerta(i, contarMinas(i)));
					mapa.get(i).setIcon(grama);
				} else {
					mapa.add(new CelulaVazia(i));
					mapa.get(i).setIcon(grama);
				}
			} else if (i % tamLinha == 9) {
				if (posicaoBombas.contains(i - tamLinha - 1) || posicaoBombas.contains(i - tamLinha)
						|| posicaoBombas.contains(i + tamLinha) || posicaoBombas.contains(i + tamLinha - 1)
						|| posicaoBombas.contains(i - 1)) {

					mapa.add(new CelulaAlerta(i, contarMinas(i)));
					mapa.get(i).setIcon(grama);
				} else {
					mapa.add(new CelulaVazia(i));
					mapa.get(i).setIcon(grama);
				}
			} else {
				if (posicaoBombas.contains(i - tamLinha - 1) || posicaoBombas.contains(i - tamLinha + 1)
						|| posicaoBombas.contains(i - tamLinha) || posicaoBombas.contains(i + tamLinha)
						|| posicaoBombas.contains(i + tamLinha - 1) || posicaoBombas.contains(i + tamLinha + 1)
						|| posicaoBombas.contains(i + 1) || posicaoBombas.contains(i - 1)) {

					mapa.add(new CelulaAlerta(i, contarMinas(i)));
					mapa.get(i).setIcon(grama);
				} else {
					mapa.add(new CelulaVazia(i));
					mapa.get(i).setIcon(grama);

				}
			}
		}
	}

	// descobrir a quantidade de bandeiras disponiveis para uso
	public int bandeirasRestantes() {
		return bandeiras;
	}

	// clicar na mina com o botao esquerdo(abrir)
	public void clicar(Celula celula) {

		totalAbertas = 0;
		for (int i = 0; i < mapa.size(); i++) {
			if (mapa.get(i).getTipo() != 3) {
				if (mapa.get(i).getDescoberta()) {
					totalAbertas++;
				}
			}
		}

		if (minasMarcadas.size() == bombasNoCampo && (totalAbertas + numBombas == mapa.size())) {
			JOptionPane.showMessageDialog(null, "Parabéns!", "Não fez mais que sua obrigação",
					JOptionPane.DEFAULT_OPTION);
			System.exit(1);
		}

		if (!celula.getBandeira()) {
			celula.setDescoberta(true);
			celula.setBackground(Color.white);

			if (celula.getTipo() == 3) {
				celula.setExplosao();
				celula.setIcon(bomba);
				JOptionPane.showMessageDialog(null, "YOU ARE A FAILURE", "U ARE A WASTE OF CARBON",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(1);

			}

			if (celula.getTipo() == 2) {

				int quantidade = celula.getNumBombasVizinhas();
				celula.setText(String.valueOf(quantidade));
				celula.setHorizontalTextPosition(SwingConstants.CENTER);
				celula.setForeground(Color.white);
				celula.setIcon(terra);
			}

			if (celula.getTipo() == 1) {

				int posicao = celula.getPosicao();
				celula.setIcon(terra);

				if (posicao < tamLinha) {
					if (posicao == 0) {
						adjacentes.add(posicao + tamLinha);
						adjacentes.add(posicao + tamLinha + 1);
						adjacentes.add(posicao + 1);

					} else if (posicao == 9) {
						adjacentes.add(posicao + tamLinha);
						adjacentes.add(posicao + tamLinha - 1);
						adjacentes.add(posicao - 1);

					} else {
						adjacentes.add(posicao + tamLinha);
						adjacentes.add(posicao + tamLinha + 1);
						adjacentes.add(posicao + 1);
						adjacentes.add(posicao + tamLinha - 1);
						adjacentes.add(posicao - 1);

					}

				} else if (posicao >= tamMapa - tamLinha) {
					if (posicao == 90) {
						adjacentes.add(posicao + 1);
						adjacentes.add(posicao - tamLinha + 1);
						adjacentes.add(posicao - tamLinha);

					} else if (posicao == 99) {
						adjacentes.add(posicao - tamLinha);
						adjacentes.add(posicao - tamLinha - 1);
						adjacentes.add(posicao - 1);
					} else {
						adjacentes.add(posicao - tamLinha);
						adjacentes.add(posicao - tamLinha - 1);
						adjacentes.add(posicao - 1);
						adjacentes.add(posicao + 1);
						adjacentes.add(posicao - tamLinha + 1);

					}
				}

				else if (posicao % tamLinha == 0) {
					adjacentes.add(posicao + tamLinha);
					adjacentes.add(posicao + tamLinha + 1);
					adjacentes.add(posicao + 1);
					adjacentes.add(posicao - tamLinha);
					adjacentes.add(posicao - tamLinha + 1);

				}

				else if (posicao % tamLinha == 9) {

					adjacentes.add(posicao + tamLinha);
					adjacentes.add(posicao + tamLinha - 1);
					adjacentes.add(posicao - 1);
					adjacentes.add(posicao - tamLinha);
					adjacentes.add(posicao - tamLinha - 1);

				} else {
					adjacentes.add(posicao - tamLinha);
					adjacentes.add(posicao - tamLinha + 1);
					adjacentes.add(posicao + 1);
					adjacentes.add(posicao - tamLinha - 1);
					adjacentes.add(posicao - 1);
					adjacentes.add(posicao + tamLinha);
					adjacentes.add(posicao + tamLinha + 1);
					adjacentes.add(posicao + tamLinha - 1);

				}

			}

			for (int i = 0; i < adjacentes.size(); i++) {

				if (mapa.get(adjacentes.get(i)).getTipo() == 2) {

					int quantidade = mapa.get(adjacentes.get(i)).getNumBombasVizinhas();
					mapa.get(adjacentes.get(i)).setText(String.valueOf(quantidade));
					mapa.get(adjacentes.get(i)).setForeground(Color.white);
					mapa.get(adjacentes.get(i)).setHorizontalTextPosition(SwingConstants.CENTER);
					mapa.get(adjacentes.get(i)).setIcon(terra);
					mapa.get(adjacentes.get(i)).setDescoberta(true);

				}

				if ((!mapa.get(adjacentes.get(i)).getBandeira())) {
					if (!mapa.get(adjacentes.get(i)).getDescoberta()) {

						clicar(mapa.get(adjacentes.get(i)));
					}

				}
			}
			totalAbertas = 0;
			for (int i = 0; i < mapa.size(); i++) {
				if (mapa.get(i).getTipo() != 3) {
					if (mapa.get(i).getDescoberta()) {
						totalAbertas++;
					}
				}
			}

			if (minasMarcadas.size() == bombasNoCampo && (totalAbertas + numBombas == mapa.size())) {
				JOptionPane.showMessageDialog(null, "Parabéns!", "Não fez mais que sua obrigação",
						JOptionPane.DEFAULT_OPTION);
				System.exit(1);
			}

		}
	}

	// clicar com botao direito(bandeira)
	public void colocarBandeira(Celula celula) {

		if ((!celula.getBandeira()) && (!celula.getDescoberta()) && bandeiras > 0) {
			celula.setBandeira(true);
			celula.setIcon(bandeira);

			bandeiras--;

		} else if (celula.getBandeira()) {
			celula.setBandeira(false);
			celula.setIcon(grama);
			bandeiras++;
		}

		for (int i = 0; i < mapa.size(); i++) {
			if (mapa.get(i).getTipo() == 3 && mapa.get(i).getBandeira()) {
				if (!minasMarcadas.contains(mapa.get(i).getPosicao())) {
					minasMarcadas.add(mapa.get(i).getPosicao());
				}

			}

		}
		totalAbertas = 0;
		for (int i = 0; i < mapa.size(); i++) {
			if (mapa.get(i).getTipo() != 3) {
				if (mapa.get(i).getDescoberta()) {
					totalAbertas++;
				}
			}
		}

		if (minasMarcadas.size() == bombasNoCampo && (totalAbertas + numBombas == mapa.size())) {
			JOptionPane.showMessageDialog(null, "Parabéns!", "Não fez mais que sua obrigação",
					JOptionPane.DEFAULT_OPTION);
			System.exit(1);
		}

	}

	public int contarMinas(int i) {
		int contador = 0;
		if (i % tamLinha == 0) {
			if (posicaoBombas.contains(i - tamLinha + 1))
				contador++;
			if (posicaoBombas.contains(i - tamLinha))
				contador++;
			if (posicaoBombas.contains(i + tamLinha))
				contador++;
			if (posicaoBombas.contains(i + tamLinha + 1))
				contador++;
			if (posicaoBombas.contains(i + 1))
				contador++;
		}

		else if (i % tamLinha == 9) {
			if (posicaoBombas.contains(i - tamLinha - 1))
				contador++;
			if (posicaoBombas.contains(i - tamLinha))
				contador++;
			if (posicaoBombas.contains(i + tamLinha))
				contador++;
			if (posicaoBombas.contains(i + tamLinha - 1))
				contador++;
			if (posicaoBombas.contains(i - 1))
				contador++;

		} else {
			if (posicaoBombas.contains(i - tamLinha - 1))
				contador++;
			if (posicaoBombas.contains(i - tamLinha + 1))
				contador++;
			if (posicaoBombas.contains(i - tamLinha))
				contador++;
			if (posicaoBombas.contains(i + tamLinha))
				contador++;
			if (posicaoBombas.contains(i + tamLinha - 1))
				contador++;
			if (posicaoBombas.contains(i + tamLinha + 1))
				contador++;
			if (posicaoBombas.contains(i + 1))
				contador++;
			if (posicaoBombas.contains(i - 1))
				contador++;
		}
		return contador;
	}

	public void adicionarCelulas() {
		for (int i = 0; i < mapa.size(); i++) {
			add(mapa.get(i));
			mapa.get(i).setPreferredSize(new Dimension(50, 50));
		}
	}

}
