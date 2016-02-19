package br.com.aulajava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aulajava.factory.ConexaoFactory;
import br.com.aulajava.model.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.criarConexao();
	
	public void UpdateorInsert(Usuario usu) {
		String sql = "update or insert into tb_usua(usu_codi,usu_nomec,usu_nome,usu_senh) " +
					 "values (?,?,?,?) " +
					 "matching(usu_codi)";
		
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usu.getCodigo());
			pstm.setString(2, usu.getNome());
			pstm.setString(3, usu.getLogin());
			pstm.setString(4, usu.getSenha());
			pstm.execute();
			ConexaoFactory.fecharConexao(con, pstm, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocorreu um erro ao cadastrar: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Excluir(Usuario usu) {
		String sql = "delete from tb_usua where usu_codi=?";
	
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usu.getCodigo());
			pstm.execute();
			ConexaoFactory.fecharConexao(con, pstm, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocorreu um erro ao cadastrar: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Usuario buscaPorCodigo(String codigo){
		String sql = "select * from tb_usua where usu_codi=?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, codigo);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()){
				Usuario usu = new Usuario();
				usu.setCodigo(codigo);
				usu.setLogin(rs.getString("usu_nome"));
				usu.setNome(rs.getString("usu_nomec"));
				usu.setSenha(rs.getString("usu_senh"));
				return usu;
			}
			ConexaoFactory.fecharConexao(con, pstm, rs);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public List<Usuario> buscaTodos(){
		String sql = "select * from tb_usua order by usu_codi";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				Usuario usu = new Usuario();
				usu.setCodigo(rs.getString("usu_codi"));
				usu.setLogin(rs.getString("usu_nome"));
				usu.setNome(rs.getString("usu_nomec"));
				usu.setSenha(rs.getString("usu_senh"));
				usuarios.add(usu);
			}
			ConexaoFactory.fecharConexao(con, pstm, rs);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuarios;
	}
	
}
