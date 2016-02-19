package br.com.aulajava;

import br.com.aulajava.model.Usuario;

import java.util.List;

import br.com.aulajava.dao.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		//Excluir();
		//testBuscarPorCodigo("002");
		testBuscarTodos();

	}

	private static void testBuscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usu = usuDAO.buscaPorCodigo(codigo);
		System.out.println(usu);
	}

	private static void testBuscarTodos() {
		// TODO Auto-generated method stub
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> usuarios = usuDAO.buscaTodos();
		for (Usuario u: usuarios){
			System.out.println(u);
		}
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
