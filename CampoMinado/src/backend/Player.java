package backend;

public class Player {

	private String nome;
	private int pontos;
	
	public Player(String nome, int pnts) {
		this.nome = nome;
		this.pontos = pontos;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
}
