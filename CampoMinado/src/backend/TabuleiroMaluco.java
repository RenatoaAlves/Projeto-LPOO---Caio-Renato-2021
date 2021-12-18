package backend;

import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import java.net.URL;

public class TabuleiroMaluco extends JPanel implements AcoesTabuleiro {

	
	public static ArrayList<Celula> mapa = new ArrayList<>();
	public static ArrayList<Integer> minasMarcadas = new ArrayList<>();
	private ArrayList<Integer> posicaoBombas = new ArrayList<>();
	private ArrayList<Integer> adjacentes = new ArrayList<>();
	private int numBombas = 10;
	public static int bandeiras = 10;
	private int tamMapa = 100;
	private int tamLinha = 10;
	public static int bombasNoCampo = 10;
	private int totalAbertas = 1;
	public static int numBombasMalucas = 0;


	Icon bomba = new ImageIcon("src\\texture_pack\\tnt.png");
	Icon terra = new ImageIcon("src\\texture_pack\\terra.jpeg");
	Icon grama = new ImageIcon("src\\texture_pack\\grama.jpeg");
	Icon bandeira = new ImageIcon("src\\texture_pack\\tocha_bandeira.png");

	public TabuleiroMaluco() {

	}

	public TabuleiroMaluco(GridLayout g) {
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
				mapa.add(new CelulaMaluca(i, 3));
				mapa.get(i).setIcon(grama);
			} else if (i % tamLinha == 0) {
				if (posicaoBombas.contains(i - tamLinha + 1) || posicaoBombas.contains(i - tamLinha)
						|| posicaoBombas.contains(i + tamLinha) || posicaoBombas.contains(i + tamLinha + 1)
						|| posicaoBombas.contains(i + 1)) {

					mapa.add(new AlertaMaluca(i, 2, contarMinas(i)));
					mapa.get(i).setIcon(grama);
				} else {
					mapa.add(new CelulaMaluca(i, 1));
					mapa.get(i).setIcon(grama);
				}
			} else if (i % tamLinha == 9) {
				if (posicaoBombas.contains(i - tamLinha - 1) || posicaoBombas.contains(i - tamLinha)
						|| posicaoBombas.contains(i + tamLinha) || posicaoBombas.contains(i + tamLinha - 1)
						|| posicaoBombas.contains(i - 1)) {

					mapa.add(new AlertaMaluca(i, 2, contarMinas(i)));
					mapa.get(i).setIcon(grama);
				} else {
					mapa.add(new CelulaMaluca(i, 1));
					mapa.get(i).setIcon(grama);
				}
			} else {
				if (posicaoBombas.contains(i - tamLinha - 1) || posicaoBombas.contains(i - tamLinha + 1)
						|| posicaoBombas.contains(i - tamLinha) || posicaoBombas.contains(i + tamLinha)
						|| posicaoBombas.contains(i + tamLinha - 1) || posicaoBombas.contains(i + tamLinha + 1)
						|| posicaoBombas.contains(i + 1) || posicaoBombas.contains(i - 1)) {

					mapa.add(new AlertaMaluca(i, 2, contarMinas(i)));
					mapa.get(i).setIcon(grama);
				} else {
					mapa.add(new CelulaMaluca(i, 1));
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
						
						if(mapa.get(adjacentes.get(i)).getTipo() != 3) {
							clicar(mapa.get(adjacentes.get(i)));
						}
						
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
		
		ativarMaluca(celula);
		

		if (celula.getBandeira()) {
			celula.setBandeira(false);
			celula.setIcon(grama);
			bandeiras++;

		}

		else if ((!celula.getBandeira()) && (!celula.getDescoberta()) && bandeiras > 0) {
			celula.setIcon(bandeira);
			celula.setBandeira(true);
			bandeiras--;
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

	public void ativarMaluca(Celula celula) {

		ArrayList<Integer> updateAlertas = new ArrayList<>();

		int probabilidade = aleatorio.nextInt(10);

		if (celula.getTipo() == 3/* && (probabilidade == 2 || probabilidade == 7)*/) {
			minasMarcadas.add(celula.getPosicao());
			mapa.get(celula.getPosicao()).setMinada(false);
			mapa.get(celula.getPosicao()).setTipo(1);

		}

		int posicao = celula.getPosicao();

		if (posicao < tamLinha) {
			if (posicao == 0) {
				updateAlertas.add(posicao + tamLinha);
				updateAlertas.add(posicao + tamLinha + 1);
				updateAlertas.add(posicao + 1);

			} else if (posicao == 9) {
				updateAlertas.add(posicao + tamLinha);
				updateAlertas.add(posicao + tamLinha - 1);
				updateAlertas.add(posicao - 1);

			} else {
				updateAlertas.add(posicao + tamLinha);
				updateAlertas.add(posicao + tamLinha + 1);
				updateAlertas.add(posicao + 1);
				updateAlertas.add(posicao + tamLinha - 1);
				updateAlertas.add(posicao - 1);

			}

		} else if (posicao >= tamMapa - tamLinha) {
			if (posicao == 90) {
				updateAlertas.add(posicao + 1);
				updateAlertas.add(posicao - tamLinha + 1);
				updateAlertas.add(posicao - tamLinha);

			} else if (posicao == 99) {
				updateAlertas.add(posicao - tamLinha);
				updateAlertas.add(posicao - tamLinha - 1);
				updateAlertas.add(posicao - 1);
			} else {
				updateAlertas.add(posicao - tamLinha);
				updateAlertas.add(posicao - tamLinha - 1);
				updateAlertas.add(posicao - 1);
				updateAlertas.add(posicao + 1);
				updateAlertas.add(posicao - tamLinha + 1);

			}
		}

		else if (posicao % tamLinha == 0) {
			updateAlertas.add(posicao + tamLinha);
			updateAlertas.add(posicao + tamLinha + 1);
			updateAlertas.add(posicao + 1);
			updateAlertas.add(posicao - tamLinha);
			updateAlertas.add(posicao - tamLinha + 1);

		}

		else if (posicao % tamLinha == 9) {

			updateAlertas.add(posicao + tamLinha);
			updateAlertas.add(posicao + tamLinha - 1);
			updateAlertas.add(posicao - 1);
			updateAlertas.add(posicao - tamLinha);
			updateAlertas.add(posicao - tamLinha - 1);

		} else {
			updateAlertas.add(posicao - tamLinha);
			updateAlertas.add(posicao - tamLinha + 1);
			updateAlertas.add(posicao + 1);
			updateAlertas.add(posicao - tamLinha - 1);
			updateAlertas.add(posicao - 1);
			updateAlertas.add(posicao + tamLinha);
			updateAlertas.add(posicao + tamLinha + 1);
			updateAlertas.add(posicao + tamLinha - 1);

		}

		for (int i = 0; i < updateAlertas.size(); i++) {
			if (mapa.get(updateAlertas.get(i)).getTipo() == 2) {

				if (mapa.get(updateAlertas.get(i)).getNumBombasVizinhas() == 1) {
					mapa.set(updateAlertas.get(i), new CelulaMaluca(celula.getPosicao(), 1));
					if (mapa.get(updateAlertas.get(i)).getDescoberta()) {
						mapa.get(updateAlertas.get(i)).setIcon(terra);
		
					} else {
						mapa.get(updateAlertas.get(i)).setIcon(grama);
					}
				} else if (mapa.get(updateAlertas.get(i)).getNumBombasVizinhas() > 1) {
					int numAtual = mapa.get(updateAlertas.get(i)).getNumBombasVizinhas();
					((AlertaMaluca) mapa.get(updateAlertas.get(i))).setNumBombasVizinhas(numAtual - 1);

				}

			}

		}

	}

}
