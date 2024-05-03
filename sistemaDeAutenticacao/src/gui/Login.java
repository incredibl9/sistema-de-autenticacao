package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import auth.DAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField tfUserLogin;
	public JPasswordField pfPasswordLogin;
	public JTextField tfEmailLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Faça seu login:");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel.setBounds(120, 37, 108, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário:");
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(31, 70, 73, 26);
		contentPane.add(lblNewLabel_1);
		
		tfUserLogin = new JTextField();
		tfUserLogin.setBounds(87, 74, 192, 20);
		contentPane.add(tfUserLogin);
		tfUserLogin.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(31, 144, 73, 26);
		contentPane.add(lblNewLabel_1_1);
		
		pfPasswordLogin = new JPasswordField();
		pfPasswordLogin.setBounds(87, 148, 192, 20);
		contentPane.add(pfPasswordLogin);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DAO.verifyUser(tfUserLogin.getText(), tfEmailLogin.getText(), pfPasswordLogin.getPassword(), Login.this);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(139, 187, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("E-mail:");
		lblNewLabel_1_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(31, 107, 73, 26);
		contentPane.add(lblNewLabel_1_2);
		
		tfEmailLogin = new JTextField();
		tfEmailLogin.setColumns(10);
		tfEmailLogin.setBounds(87, 111, 192, 20);
		contentPane.add(tfEmailLogin);
	}
}
