package properties;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

//Classe responsável por ler as configurações do config.properties.
public class ConfigReader {
	public static void main(String[] args) {
		Properties propriedades = new Properties(); 
		try (InputStream input = ConfigReader.class.getResourceAsStream("config.properties")) {
			propriedades.load(input); 
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Erro ao iniciar o arquivo de configuração: " +e.getMessage());
			System.exit(1);
		}
		
		String dbUrl = propriedades.getProperty("dbUrl");
		String dbUser = propriedades.getProperty("dbUser");
		String dbPassword = propriedades.getProperty("dbPassword");
		
		System.out.printf("URL DO BANCO DE DADOS: " + dbUrl + "\nUSER DO BANCO DE DADOS: " + dbUser + "\nSENHA DO BANCO DE DADOS: " + dbPassword);
		
	}
}
