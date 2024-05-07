package gui;

import java.awt.EventQueue;
import auth.DAO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.security.auth.login.LoginContext;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Viewer extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPanel profile;
	public JPanel cards;
	public JTextField tfUserLogin;
	public JPasswordField pfPasswordLogin;
	public JTextField tfUserSignUp;
	public JTextField tfEmailSignUp;
	public JPasswordField pfPasswordSignUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewer frame = new Viewer();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Viewer() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
			
		cards = new JPanel();
		cards.setBackground(Color.WHITE);
		cards.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(cards);
		cards.setLayout(new CardLayout(0, 0));
		
		getContentPane().add(cards);
		
		JPanel login = new JPanel();
		login.setBackground(Color.WHITE);
		login.setBorder(new EmptyBorder(0, 0, 0, 0));
		cards.add(login, "login");
		login.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 204));
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBounds(0, 0, 195, 261);
		login.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 23));
		lblNewLabel.setBounds(59, 118, 79, 22);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autentique-se");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_1.setBounds(59, 138, 79, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuário:");
		lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(205, 77, 54, 14);
		login.add(lblNewLabel_2);
		
		tfUserLogin = new JTextField();
		tfUserLogin.setBounds(205, 94, 168, 20);
		login.add(tfUserLogin);
		tfUserLogin.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Senha:");
		lblNewLabel_2_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(205, 125, 54, 14);
		login.add(lblNewLabel_2_1);
		
		pfPasswordLogin = new JPasswordField();
		pfPasswordLogin.setBounds(205, 147, 168, 20);
		login.add(pfPasswordLogin);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO.verifyUser(tfUserLogin.getText(), new String(pfPasswordSignUp.getPassword()), Viewer.this);
			}
		});
		btnEntrar.setBackground(new Color(0, 102, 204));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFont(new Font("Poppins", Font.BOLD, 11));
		btnEntrar.setBounds(205, 194, 89, 23);
		login.add(btnEntrar);
		
		JLabel lblNewLabel_3 = new JLabel("Registre-se");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout) cards.getLayout();
				cardLayout.show(cards, "signup");
			}
				
		});
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setForeground(new Color(0, 120, 215));
		lblNewLabel_3.setFont(new Font("Poppins", Font.BOLD, 11));
		lblNewLabel_3.setBounds(304, 198, 69, 14);
		login.add(lblNewLabel_3);
		
		JPanel signup = new JPanel();
		signup.setBackground(Color.WHITE);
		signup.setBorder(new EmptyBorder(0, 0, 0, 0));
		cards.add(signup, "signup");
		signup.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1_1.setBackground(new Color(0, 102, 204));
		panel_1_1.setBounds(199, 0, 195, 261);
		signup.add(panel_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("REGISTRE-SE");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Poppins", Font.BOLD, 23));
		lblNewLabel_4.setBounds(24, 116, 146, 22);
		panel_1_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("Junte-se a nós.");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_1_1.setBounds(59, 139, 87, 14);
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Usuário:");
		lblNewLabel_2_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(10, 45, 54, 14);
		signup.add(lblNewLabel_2_2);
		
		cards.add(login, "login");
		
		tfUserSignUp = new JTextField();
		tfUserSignUp.setBounds(10, 70, 144, 20);
		signup.add(tfUserSignUp);
		tfUserSignUp.setColumns(10);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("E-mail:");
		lblNewLabel_2_2_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_2_2_1.setBounds(10, 101, 54, 14);
		signup.add(lblNewLabel_2_2_1);
		
		tfEmailSignUp = new JTextField();
		tfEmailSignUp.setColumns(10);
		tfEmailSignUp.setBounds(10, 126, 144, 20);
		signup.add(tfEmailSignUp);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Senha:");
		lblNewLabel_2_2_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_2_2_2.setBounds(10, 157, 54, 14);
		signup.add(lblNewLabel_2_2_2);
		
		pfPasswordSignUp = new JPasswordField();
		pfPasswordSignUp.setBounds(10, 182, 144, 20);
		signup.add(pfPasswordSignUp);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO.signUpUser(tfUserSignUp.getText(), tfEmailSignUp.getText(), new String(pfPasswordSignUp.getPassword())//
						, Viewer.this);
			}
		});
		btnRegistrar.setBackground(new Color(0, 102, 204));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Poppins", Font.BOLD, 11));
		btnRegistrar.setBounds(97, 213, 89, 23);
		signup.add(btnRegistrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) cards.getLayout();
				cardLayout.show(cards, "login");
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Poppins", Font.BOLD, 11));
		btnVoltar.setBackground(new Color(0, 102, 204));
		btnVoltar.setBounds(10, 213, 77, 23);
		signup.add(btnVoltar);
		
		JPanel profile = new JPanel();
		profile.setBorder(new EmptyBorder(0, 0, 0, 0));
		profile.setBackground(new Color(0, 102, 204));
		cards.add(profile, "profile");
		profile.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Você foi autenticado.");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_5.setBounds(115, 111, 165, 14);
		profile.add(lblNewLabel_5);
		
		cards.add(signup, "signup");
		
				
	}
}
