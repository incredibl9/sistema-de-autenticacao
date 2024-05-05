package auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dbconnector.DBConnection;
import gui.Viewer;

public class DAO {
	public static void verifyUser(String username, String password, Viewer viewer) {
		if(viewer.tfUserLogin.getText().isBlank() || viewer.pfPasswordLogin.getText().isBlank()) {
		JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente.");
		} else {
			try {
				Connection con = DBConnection.doConnection();
				
				String sql = "SELECT * FROM usuario WHERE nome=? AND senha=?";
				
				PreparedStatement stmt = con.prepareStatement(sql); 
				stmt.setString(1, viewer.tfUserLogin.getText());
				stmt.setString(2, new String(viewer.pfPasswordLogin.getPassword()));
				
				ResultSet rs = stmt.executeQuery(); 
				
				if(rs.next()) {
					
				} else {
					JOptionPane.showMessageDialog(null, "Credenciais incorretas!");
				}
				
				con.close();
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void signUpUser(String username, String email, String password, Viewer viewer) {
		if(viewer.tfUserSignUp.getText().isBlank() || viewer.tfEmailSignUp.getText().isBlank() //
			|| viewer.pfPasswordSignUp.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente.");
		} else {
			try {
				Connection con = DBConnection.doConnection();
				
				String sql = "INSERT INTO usuario(nome, email, senha) VALUES(?,?,?)";
				
				PreparedStatement stmt = con.prepareStatement(sql); 
				
				stmt.setString(1, viewer.tfUserSignUp.getText());
				stmt.setString(2, viewer.tfEmailSignUp.getText());
				stmt.setString(3, new String(viewer.pfPasswordSignUp.getPassword()));
				
				JOptionPane.showMessageDialog(null, "Usuário cadastrado.");
				viewer.tfUserSignUp.setText("");
				viewer.tfEmailSignUp.setText("");
				viewer.pfPasswordSignUp.setText("");
				
				con.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
