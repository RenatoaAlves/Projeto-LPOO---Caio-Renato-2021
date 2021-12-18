package frontend;

import backend.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;


public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	public static String nome = "unknown";
	private BestTimes ranking; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Menu(){
		
		this.ranking = new BestTimes();
		
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setType(Type.POPUP);
		setFont(new Font("Minecraft", Font.PLAIN, 12));
		setTitle("Campo Minado");
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(153, 102, 51));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Jogar\r\n");
		btnNewButton.setFont(new Font("Minecraft", Font.PLAIN, 11));
		btnNewButton.setBounds(71, 215, 113, 84);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			//JOGO TRADICIONAL
			public void actionPerformed(ActionEvent e) {
				nome = user.getText();
				new Tela();
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.setFont(new Font("Minecraft", Font.PLAIN, 11));
		btnNewButton_1.setBounds(0, 326, 484, 23);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_3 = new JButton("Jogar\r\n");
		btnNewButton_3.setFont(new Font("Minecraft", Font.PLAIN, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			//JOGO MALUCO
			public void actionPerformed(ActionEvent e) {
				nome = user.getText();
				new Tela(1);
			}
		});
		btnNewButton_3.setBounds(288, 215, 113, 84);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		contentPane.add(btnNewButton_3);
		
		JTextPane txtpnTradicional = new JTextPane();
		txtpnTradicional.setFont(new Font("Minecraft", Font.PLAIN, 11));
		txtpnTradicional.setBackground(new Color(153, 102, 51));
		txtpnTradicional.setText("tradicional");
		txtpnTradicional.setBounds(98, 194, 67, 20);
		contentPane.add(txtpnTradicional);
		
		JTextPane txtpnMaluco = new JTextPane();
		txtpnMaluco.setFont(new Font("Minecraft", Font.PLAIN, 11));
		txtpnMaluco.setText("Maluco\r\n");
		txtpnMaluco.setBackground(new Color(153, 102, 51));
		txtpnMaluco.setBounds(325, 194, 67, 20);
		contentPane.add(txtpnMaluco);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(0, 204, 51));
		textPane.setBounds(0, 0, 484, 117);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(new Color(0, 204, 51));
		textPane_1.setBounds(0, 110, 52, 20);
		contentPane.add(textPane_1);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBackground(new Color(0, 204, 51));
		textPane_1_1.setBounds(43, 110, 52, 20);
		contentPane.add(textPane_1_1);
		
		JTextPane textPane_1_2 = new JTextPane();
		textPane_1_2.setBackground(new Color(0, 204, 51));
		textPane_1_2.setBounds(98, 110, 52, 20);
		contentPane.add(textPane_1_2);
		
		JTextPane textPane_1_3 = new JTextPane();
		textPane_1_3.setBackground(new Color(0, 204, 51));
		textPane_1_3.setBounds(145, 110, 22, 20);
		contentPane.add(textPane_1_3);
		
		JTextPane textPane_1_3_1 = new JTextPane();
		textPane_1_3_1.setBackground(new Color(0, 204, 51));
		textPane_1_3_1.setBounds(79, 110, 22, 20);
		contentPane.add(textPane_1_3_1);
		
		JTextPane textPane_1_3_2 = new JTextPane();
		textPane_1_3_2.setBackground(new Color(0, 204, 51));
		textPane_1_3_2.setBounds(162, 126, 22, 20);
		contentPane.add(textPane_1_3_2);
		
		JTextPane textPane_1_3_3 = new JTextPane();
		textPane_1_3_3.setBackground(new Color(0, 204, 51));
		textPane_1_3_3.setBounds(160, 110, 22, 20);
		contentPane.add(textPane_1_3_3);
		
		JTextPane textPane_1_3_4 = new JTextPane();
		textPane_1_3_4.setBackground(new Color(0, 204, 51));
		textPane_1_3_4.setBounds(145, 128, 22, 20);
		contentPane.add(textPane_1_3_4);
		
		JTextPane textPane_1_3_5 = new JTextPane();
		textPane_1_3_5.setBackground(new Color(0, 204, 51));
		textPane_1_3_5.setBounds(143, 141, 22, 20);
		contentPane.add(textPane_1_3_5);
		
		JTextPane textPane_1_3_6 = new JTextPane();
		textPane_1_3_6.setBackground(new Color(0, 204, 51));
		textPane_1_3_6.setBounds(128, 128, 22, 20);
		contentPane.add(textPane_1_3_6);
		
		JTextPane textPane_1_3_7 = new JTextPane();
		textPane_1_3_7.setBackground(new Color(0, 204, 51));
		textPane_1_3_7.setBounds(162, 110, 22, 20);
		contentPane.add(textPane_1_3_7);
		
		JTextPane textPane_1_3_8 = new JTextPane();
		textPane_1_3_8.setBackground(new Color(0, 204, 51));
		textPane_1_3_8.setBounds(160, 128, 22, 20);
		contentPane.add(textPane_1_3_8);
		
		JTextPane textPane_1_3_9 = new JTextPane();
		textPane_1_3_9.setBackground(new Color(0, 204, 51));
		textPane_1_3_9.setBounds(177, 110, 22, 20);
		contentPane.add(textPane_1_3_9);
		
		JTextPane textPane_1_3_10 = new JTextPane();
		textPane_1_3_10.setBackground(new Color(0, 204, 51));
		textPane_1_3_10.setBounds(187, 126, 22, 20);
		contentPane.add(textPane_1_3_10);
		
		JTextPane textPane_1_3_11 = new JTextPane();
		textPane_1_3_11.setBackground(new Color(0, 204, 51));
		textPane_1_3_11.setBounds(197, 141, 22, 20);
		contentPane.add(textPane_1_3_11);
		
		JTextPane textPane_1_3_12 = new JTextPane();
		textPane_1_3_12.setBackground(new Color(0, 204, 51));
		textPane_1_3_12.setBounds(209, 128, 22, 20);
		contentPane.add(textPane_1_3_12);
		
		JTextPane textPane_1_3_13 = new JTextPane();
		textPane_1_3_13.setBackground(new Color(0, 204, 51));
		textPane_1_3_13.setBounds(194, 110, 22, 20);
		contentPane.add(textPane_1_3_13);
		
		JTextPane textPane_1_3_14 = new JTextPane();
		textPane_1_3_14.setBackground(new Color(0, 204, 51));
		textPane_1_3_14.setBounds(209, 110, 22, 20);
		contentPane.add(textPane_1_3_14);
		
		JTextPane textPane_1_3_15 = new JTextPane();
		textPane_1_3_15.setBackground(new Color(0, 204, 51));
		textPane_1_3_15.setBounds(177, 128, 22, 20);
		contentPane.add(textPane_1_3_15);
		
		JTextPane textPane_1_3_16 = new JTextPane();
		textPane_1_3_16.setBackground(new Color(0, 204, 51));
		textPane_1_3_16.setBounds(0, 128, 22, 20);
		contentPane.add(textPane_1_3_16);
		
		JTextPane textPane_1_3_17 = new JTextPane();
		textPane_1_3_17.setBackground(new Color(0, 204, 51));
		textPane_1_3_17.setBounds(10, 141, 22, 20);
		contentPane.add(textPane_1_3_17);
		
		JTextPane textPane_1_3_18 = new JTextPane();
		textPane_1_3_18.setBackground(new Color(0, 204, 51));
		textPane_1_3_18.setBounds(10, 157, 22, 20);
		contentPane.add(textPane_1_3_18);
		
		JTextPane textPane_1_3_19 = new JTextPane();
		textPane_1_3_19.setBackground(new Color(0, 204, 51));
		textPane_1_3_19.setBounds(10, 128, 22, 20);
		contentPane.add(textPane_1_3_19);
		
		JTextPane textPane_1_3_20 = new JTextPane();
		textPane_1_3_20.setBackground(new Color(0, 204, 51));
		textPane_1_3_20.setBounds(71, 126, 22, 20);
		contentPane.add(textPane_1_3_20);
		
		JTextPane textPane_1_3_21 = new JTextPane();
		textPane_1_3_21.setBackground(new Color(0, 204, 51));
		textPane_1_3_21.setBounds(71, 141, 22, 20);
		contentPane.add(textPane_1_3_21);
		
		JTextPane textPane_1_3_22 = new JTextPane();
		textPane_1_3_22.setBackground(new Color(0, 204, 51));
		textPane_1_3_22.setBounds(291, 110, 22, 20);
		contentPane.add(textPane_1_3_22);
		
		JTextPane textPane_1_3_23 = new JTextPane();
		textPane_1_3_23.setBackground(new Color(0, 204, 51));
		textPane_1_3_23.setBounds(259, 110, 22, 20);
		contentPane.add(textPane_1_3_23);
		
		JTextPane textPane_1_3_24 = new JTextPane();
		textPane_1_3_24.setBackground(new Color(0, 204, 51));
		textPane_1_3_24.setBounds(259, 128, 22, 20);
		contentPane.add(textPane_1_3_24);
		
		JTextPane textPane_1_3_25 = new JTextPane();
		textPane_1_3_25.setBackground(new Color(0, 204, 51));
		textPane_1_3_25.setBounds(241, 110, 22, 20);
		contentPane.add(textPane_1_3_25);
		
		JTextPane textPane_1_3_26 = new JTextPane();
		textPane_1_3_26.setBackground(new Color(0, 204, 51));
		textPane_1_3_26.setBounds(349, 110, 22, 20);
		contentPane.add(textPane_1_3_26);
		
		JTextPane textPane_1_3_27 = new JTextPane();
		textPane_1_3_27.setBackground(new Color(0, 204, 51));
		textPane_1_3_27.setBounds(334, 110, 22, 20);
		contentPane.add(textPane_1_3_27);
		
		JTextPane textPane_1_3_28 = new JTextPane();
		textPane_1_3_28.setBackground(new Color(0, 204, 51));
		textPane_1_3_28.setBounds(370, 110, 22, 20);
		contentPane.add(textPane_1_3_28);
		
		JTextPane textPane_1_3_29 = new JTextPane();
		textPane_1_3_29.setBackground(new Color(0, 204, 51));
		textPane_1_3_29.setBounds(344, 126, 22, 20);
		contentPane.add(textPane_1_3_29);
		
		JTextPane textPane_1_3_30 = new JTextPane();
		textPane_1_3_30.setBackground(new Color(0, 204, 51));
		textPane_1_3_30.setBounds(359, 128, 22, 20);
		contentPane.add(textPane_1_3_30);
		
		JTextPane textPane_1_3_31 = new JTextPane();
		textPane_1_3_31.setBackground(new Color(0, 204, 51));
		textPane_1_3_31.setBounds(381, 128, 22, 20);
		contentPane.add(textPane_1_3_31);
		
		JTextPane textPane_1_3_32 = new JTextPane();
		textPane_1_3_32.setBackground(new Color(0, 204, 51));
		textPane_1_3_32.setBounds(381, 110, 22, 20);
		contentPane.add(textPane_1_3_32);
		
		JTextPane textPane_1_3_33 = new JTextPane();
		textPane_1_3_33.setBackground(new Color(0, 204, 51));
		textPane_1_3_33.setBounds(359, 141, 22, 20);
		contentPane.add(textPane_1_3_33);
		
		JTextPane textPane_1_3_34 = new JTextPane();
		textPane_1_3_34.setBackground(new Color(0, 204, 51));
		textPane_1_3_34.setBounds(413, 110, 22, 20);
		contentPane.add(textPane_1_3_34);
		
		JTextPane textPane_1_3_35 = new JTextPane();
		textPane_1_3_35.setBackground(new Color(0, 204, 51));
		textPane_1_3_35.setBounds(427, 110, 22, 20);
		contentPane.add(textPane_1_3_35);
		
		JTextPane textPane_1_3_36 = new JTextPane();
		textPane_1_3_36.setBackground(new Color(0, 204, 51));
		textPane_1_3_36.setBounds(445, 110, 22, 20);
		contentPane.add(textPane_1_3_36);
		
		JTextPane textPane_1_3_37 = new JTextPane();
		textPane_1_3_37.setBackground(new Color(0, 204, 51));
		textPane_1_3_37.setBounds(462, 110, 22, 20);
		contentPane.add(textPane_1_3_37);
		
		JTextPane textPane_1_3_38 = new JTextPane();
		textPane_1_3_38.setBackground(new Color(0, 204, 51));
		textPane_1_3_38.setBounds(423, 126, 22, 20);
		contentPane.add(textPane_1_3_38);
		
		JTextPane textPane_1_3_39 = new JTextPane();
		textPane_1_3_39.setBackground(new Color(0, 204, 51));
		textPane_1_3_39.setBounds(437, 128, 22, 20);
		contentPane.add(textPane_1_3_39);
		
		JTextPane textPane_1_3_40 = new JTextPane();
		textPane_1_3_40.setBackground(new Color(0, 204, 51));
		textPane_1_3_40.setBounds(459, 128, 22, 20);
		contentPane.add(textPane_1_3_40);
		
		JTextPane textPane_1_3_41 = new JTextPane();
		textPane_1_3_41.setBackground(new Color(0, 204, 51));
		textPane_1_3_41.setBounds(462, 128, 22, 20);
		contentPane.add(textPane_1_3_41);
		
		JTextPane textPane_1_3_42 = new JTextPane();
		textPane_1_3_42.setBackground(new Color(0, 204, 51));
		textPane_1_3_42.setBounds(437, 141, 22, 20);
		contentPane.add(textPane_1_3_42);
		
		JTextPane textPane_1_3_43 = new JTextPane();
		textPane_1_3_43.setBackground(new Color(0, 204, 51));
		textPane_1_3_43.setBounds(455, 141, 22, 20);
		contentPane.add(textPane_1_3_43);
		
		JTextPane textPane_1_3_44 = new JTextPane();
		textPane_1_3_44.setBackground(new Color(0, 204, 51));
		textPane_1_3_44.setBounds(462, 141, 22, 20);
		contentPane.add(textPane_1_3_44);
		
		JTextPane textPane_1_3_45 = new JTextPane();
		textPane_1_3_45.setBackground(new Color(0, 204, 51));
		textPane_1_3_45.setBounds(445, 157, 22, 20);
		contentPane.add(textPane_1_3_45);
		
		JTextPane textPane_1_3_46 = new JTextPane();
		textPane_1_3_46.setBackground(new Color(0, 204, 51));
		textPane_1_3_46.setBounds(462, 157, 22, 20);
		contentPane.add(textPane_1_3_46);
		
		JTextPane textPane_1_3_47 = new JTextPane();
		textPane_1_3_47.setBackground(new Color(0, 204, 51));
		textPane_1_3_47.setBounds(462, 176, 22, 20);
		contentPane.add(textPane_1_3_47);
		
		JButton button = new JButton("New button");
		button.setBounds(76, 245, 89, 23);
		contentPane.add(button);
		
		JTextArea txtrUser = new JTextArea();
		txtrUser.setBackground(new Color(153, 102, 51));
		txtrUser.setFont(new Font("Minecraft", Font.PLAIN, 13));
		txtrUser.setText("User\r\n");
		txtrUser.setBounds(219, 401, 77, 12);
		contentPane.add(txtrUser);
		
		user = new JTextField();
		user.setToolTipText("User");
		user.setFont(new Font("Minecraft", Font.PLAIN, 11));
		user.setBounds(197, 419, 86, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("Best Times");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ranking.abrirRanking();
			}
		});
		btnNewButton_1_1.setFont(new Font("Minecraft", Font.PLAIN, 11));
		btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_1.setBounds(0, 354, 484, 23);
		contentPane.add(btnNewButton_1_1);
	}
	public JTextField getUser() {
		return user;
	}
}
