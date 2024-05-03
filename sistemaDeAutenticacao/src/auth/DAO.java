package auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dbconnector.DBConnection;
import gui.Login;

public class DAO {
	
	//Verificar o usuário
	public static void verifyUser(String usuario, String email, char[] senha, Login login) throws SQLException {
		if(login.tfUserLogin.getText().isBlank() || login.tfEmailLogin.getText().isBlank() || login.pfPasswordLogin.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
		} else {
			try {
			Connection con = DBConnection.doConnection();
			
			String sql = "SELECT * FROM usuario WHERE nome=? and email=? and senha=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, login.tfUserLogin.getText());
			stmt.setString(2, login.tfEmailLogin.getText());
			stmt.setString(3, new String(login.pfPasswordLogin.getPassword()));
			
			ResultSet rs = stmt.executeQuery();
			
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");
				}else {
					JOptionPane.showMessageDialog(null, "Credenciais incorretas.");
				}
				
				con.close();
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
