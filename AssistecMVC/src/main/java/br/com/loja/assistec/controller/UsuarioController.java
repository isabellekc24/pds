
package br.com.loja.assistec.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.model.UsuarioDAO;

public class UsuarioController {

	public ArrayList<Usuario> listarUsuarios() throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.selecionarUsuarios();
	}

	public void salvar(String nome, String fone, String login, String senha, String perfil) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setFone(fone);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setPerfil(perfil);

		new UsuarioDAO().salvar(usuario);
	}

}
