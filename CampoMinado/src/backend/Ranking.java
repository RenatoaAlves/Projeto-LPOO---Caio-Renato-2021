package backend;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Ranking{
		
	
	private ArrayList<Player> listaRanking = new ArrayList<>();
	public static ArrayList<String> rankingString = new ArrayList<>();
	
	public void lerRanking() throws FileNotFoundException {
		
		File file = new File("ranking.txt");
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
			String dados = scan.nextLine();
			String[] info = dados.split(" ");
			listaRanking.add(new Player(info[0], Integer.parseInt(info[1])));
		}
		scan.close();
		
		Collections.sort(listaRanking);
		
		for(int i = 0; i<listaRanking.size(); i++) {
			rankingString.add(listaRanking.get(i).getNome() + " " + listaRanking.get(i).getTempo());
		}
	}
	
	public ArrayList<String> getRankingString(){
		
		return rankingString;
	}
	
	
	

	
	
	
	
}
