package br.com.aulajava.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexaoFactory {

	private static final String DRIVER = "org.firebirdsql.jdbc.FBDriver";
	private static final String URL = "jdbc:firebirdsql:localhost/3050:c:/sistemas/sge/dados/db_sge.fdb";
	private static final String USUARIO = "SYSDBA";
	private static final String SENHA = "masterkey";

	public static Connection criarConexao() {
		
		Connection con = null;
		try {
			
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		} catch (Exception e) {
			System.out.println("Erro ao criar conexão com o banco: " + URL);
			e.printStackTrace();
		}
		
		return con;
	}

	public static void fecharConexao(Connection con, PreparedStatement pstm, ResultSet rs) {
		try {
			if (con != null) con.close();
			if (pstm != null) pstm.close();
			if (rs != null) rs.close();
		} catch (Exception e) {
		}
	}

}
