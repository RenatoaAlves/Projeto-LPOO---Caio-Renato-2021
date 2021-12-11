package backend;

import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class Tabuleiro extends JPanel {

	public static ArrayList<Celula> mapa = new ArrayList<>();
	private ArrayList<Integer> posicaoBombas = new ArrayList<>();
	private ArrayList<Integer> adjacentes = new ArrayList<>();
	private int numBombas = 10;
	private int bandeiras = numBombas;
	public static int tamMapa = 100;
	public static int tamLinha = 10;

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
			} else if (i % tamLinha == 0) {
				if (posicaoBombas.contains(i - tamLinha + 1) || posicaoBombas.contains(i - tamLinha)
						|| posicaoBombas.contains(i + tamLinha) || posicaoBombas.contains(i + tamLinha + 1)
						|| posicaoBombas.contains(i + 1)) {

					mapa.add(new CelulaAlerta(i, contarMinas(i)));
				} else {
					mapa.add(new CelulaVazia(i));
				}
			} else if (i % tamLinha == 9) {
				if (posicaoBombas.contains(i - tamLinha - 1) || posicaoBombas.contains(i - tamLinha)
						|| posicaoBombas.contains(i + tamLinha) || posicaoBombas.contains(i + tamLinha - 1)
						|| posicaoBombas.contains(i - 1)) {

					mapa.add(new CelulaAlerta(i, contarMinas(i)));
				} else {
					mapa.add(new CelulaVazia(i));
				}
			} else {
				if (posicaoBombas.contains(i - tamLinha - 1) || posicaoBombas.contains(i - tamLinha + 1)
						|| posicaoBombas.contains(i - tamLinha) || posicaoBombas.contains(i + tamLinha)
						|| posicaoBombas.contains(i + tamLinha - 1) || posicaoBombas.contains(i + tamLinha + 1)
						|| posicaoBombas.contains(i + 1) || posicaoBombas.contains(i - 1)) {

					mapa.add(new CelulaAlerta(i, contarMinas(i)));
				} else {
					mapa.add(new CelulaVazia(i));
					
				}
			}
		}
	}

	// descobrir a quantidade de bandeiras disponiveis para uso
	public int bandeirasRestantes() {
		return bandeiras;
	}

	// clicar na mina
	public void clicar(Celula celula) {


		if (!celula.getBandeira()) {
			celula.setDescoberta(true);
			celula.setBackground(Color.white);

			if (celula.getTipo() == 3) {
				celula.setExplosao();
				celula.setText("B");
			}

			if (celula.getTipo() == 2) {
				int quantidade = celula.getNumBombasVizinhas();
				celula.setText(String.valueOf(quantidade));
			}

			if (celula.getTipo() == 1) {
				int posicao = celula.getPosicao();

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
						
			
			for(int i=0;i<adjacentes.size();i++) {
			
				if (mapa.get(adjacentes.get(i)).getTipo() == 2) {
					int quantidade = mapa.get(adjacentes.get(i)).getNumBombasVizinhas();
					mapa.get(adjacentes.get(i)).setText(String.valueOf(quantidade));
					mapa.get(adjacentes.get(i)).setBackground(Color.white);
					mapa.get(adjacentes.get(i)).setDescoberta(true);
				}
				
				if((!mapa.get(adjacentes.get(i)).getBandeira())) {
					if(!mapa.get(adjacentes.get(i)).getDescoberta()) {
						clicar(mapa.get(adjacentes.get(i)));
					}

				}
			}

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
