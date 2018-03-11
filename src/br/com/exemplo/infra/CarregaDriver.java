package br.com.exemplo.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CarregaDriver {
	public static void main(String args[]) {

		try {
			Class.forName("org.h2.Driver");
			System.out.println("O driver foi carregado!");

			Connection conn = DriverManager.getConnection("jdbc:h2:mem:dbaluno", "", "");
			System.out.println("\nConexao Efeturada: " + conn);
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE alunos (id INTEGER not null, nome VARCHAR(255))");
			System.out.println("\nTabela Criada!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Não consegui carregar o driver!" + e.getMessage());
		} catch (SQLException ex) {
			System.out.println("Erro na conexao: " + ex.getMessage());
		}

	}
}
