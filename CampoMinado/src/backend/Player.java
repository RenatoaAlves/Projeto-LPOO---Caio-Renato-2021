package backend;

public class Player implements Comparable<Player> {

	private String nome;
	private int tempo;
	
	public Player(String nome, int tempo) {
		this.nome = nome;
		this.tempo = tempo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTempo() {
		return tempo;
	}
	public void setPontos(int tempo) {
		this.tempo = tempo;
	}


	@Override
	public int compareTo(Player o) {
		return (this.tempo - o.getTempo());
	}
	
}
