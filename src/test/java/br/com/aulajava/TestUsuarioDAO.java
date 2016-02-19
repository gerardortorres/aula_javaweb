package br.com.aulajava;

import br.com.aulajava.model.Usuario;
import br.com.aulajava.dao.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		Excluir();

	}

	public static void Excluir(){
		Usuario usu = new Usuario();
		/**
		 * Criando o usuario
		 */
		usu.setCodigo("998");
		/**
		 * Cadastrando o usuario no banco de dados
		 */
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.Excluir(usu);
		
		System.out.println("Exclusão com sucesso!");
	}
	
	public static void UpdateorInsert(){
		Usuario usu = new Usuario();
		/**
		 * Criando o usuario
		 */
		usu.setCodigo("998");
		usu.setNome("TesteWeb");
		usu.setLogin("aula");
		usu.setSenha("123456");
		/**
		 * Cadastrando o usuario no banco de dados
		 */
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.UpdateorInsert(usu);
		
		System.out.println("Cadastro com sucesso!");
	}

}
