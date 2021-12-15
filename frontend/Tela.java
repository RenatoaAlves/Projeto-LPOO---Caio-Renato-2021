package frontend;

import backend.*;
import javax.swing.*;
import java.awt.*;

public class Tela {
	
	private static JFrame frame;
	
	
	public Tela() {
		JPanel tela = new Tabuleiro(new GridLayout(10, 10));
		frame = new JFrame();
		frame.setTitle("Campo Minado " + " -  Bandeiras restantes: ");
		frame.setVisible(true);
		frame.setSize(550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		
		
		
		frame.setContentPane(tela);
		frame.pack(); 
		
		}
	
	
	//iniciar campo maluco
	public Tela(int i) {
		frame = new JFrame();
		
		frame.setTitle("Campo Minado");
		frame.setVisible(true);
		frame.setSize(550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JPanel tela = new TabuleiroMaluco(new GridLayout(10, 10));
		
		
		frame.setContentPane(tela);
		frame.pack();
	}
	
	
	
}
