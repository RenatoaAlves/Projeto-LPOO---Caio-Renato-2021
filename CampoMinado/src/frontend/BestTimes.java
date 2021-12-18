package frontend;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.io.FileNotFoundException;

import javax.swing.table.DefaultTableModel;

import backend.Ranking;

import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

public class BestTimes extends JFrame {
	
	private Ranking ranking;
	private ArrayList<String> texto = Ranking.rankingString;
	private String str;
	

   
    public void abrirRanking() {
    	

    	
    	try {
			ranking.lerRanking();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
     
    	
    	
        EventQueue.invokeLater(new Runnable() {
           
        	
        	public void run() {
                try {
                    BestTimes frame = new BestTimes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
    }
    


	public BestTimes(){
    	
    	this.str = "";
    	
    	for(String nome : texto) {
    		this.str+=nome + "\n";
    	}
		
    	this.ranking = new Ranking();
    	
        getContentPane().setBackground(new Color(139, 69, 19));
        getContentPane().setLayout(null);
        
        JTextPane BestTimes = new JTextPane();
        
        BestTimes.setText(str);
        BestTimes.setEditable(false);
        BestTimes.setBounds(10, 31, 190, 214);
        getContentPane().add(BestTimes);
        setResizable(false);
        setTitle("Best Times");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 226, 317);
        
        
    	
    
    }
} 
