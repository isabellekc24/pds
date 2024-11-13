
package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import br.com.loja.assistec.model.Usuario;
import br.com.loja.assistec.view.ListarUsuariosView;

public class ListarUsuariosController {
	public ListarUsuariosView listar;

	public ListarUsuariosController() {
		listar = new ListarUsuariosView();
		listar.setLocationRelativeTo(null);
		listar.setVisible(true);
		configurarListeners();
		carregarUsuarios();
	}

	private void configurarListeners() {
		listar.addListarUsuariosListeners(new ListarUsuariosListener());
		listar.addWindowListener(new JanelaAberturaListener());
	}

	private void carregarUsuarios() {

	}
	
	private class ListarUsuariosListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			switch(comando) {
			case "BotaoCadastrarAction":
				abrirCadastroUsuario(null);
				break;
			case "BotaoFecharAction":
				listar.dispose();
			default:
				break;
			}
		}
	}


	public void abrirCadastroUsuario(Usuario usuarioSelecionado) {
		
	}
	
	public class JanelaAberturaListener extends WindowAdapter{
		public void windowOpened(WindowEvent e) {
			carregarUsuarios();
		}
	}
}
