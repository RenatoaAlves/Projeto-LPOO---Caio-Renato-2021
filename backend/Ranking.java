package backend;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ranking {
	
	private String nome;
	private int pontos;	
	
	ArrayList<Player> listaRanking = new ArrayList<>();
	
	public Ranking(String nome, int pontos) {
		this.nome = nome;
		this.pontos = pontos;
	}
	
	public void adicionarRank() {
		Player jogador = new Player(nome, pontos);	
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("ranking.txt"));
			writer.write(jogador.getNome() + "," + jogador.getPontos());
			writer.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	
	
}
