package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.assistec.view.MensagemView;
import br.com.loja.assistec.view.PrincipalView;

public class PrincipalController {
	private PrincipalView principalView;
	protected String login;
	protected String perfil;

	public PrincipalController(String login, String perfil) {
		this.login = login;
		this.perfil = perfil;
		this.principalView = new PrincipalView();
		configurarJanela();
		// Configura o controlador para responder a eventos
		configurarListeners();

	}

	private void configurarJanela() {
		principalView.setLocationRelativeTo(null);
		principalView.setVisible(true);
	}

	private class MenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();

			switch (comando) {
			case "MenuUsuariosAction":
				try {
					abrirListagemUsuarios();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case "MenuSairAction":
				sairDoSistema();
				break;
			case "MenuSobreAction":
				mostrarInformacoesSobre();
				break;
			default:
				break;
			}
		}
	}

	private void configurarListeners() {
		principalView.addPrincipalViewListener(new MenuActionListener());
		principalView.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				configurarPerfilUsuario();
			}
		});
	}

	private void abrirListagemUsuarios() throws SQLException {
		new ListarUsuarioController();
	}

	private void sairDoSistema() {
		MensagemView mv = new MensagemView("Tem certeza que deseja sair?");
		int confirmacao = mv.getResposta();
		if (confirmacao == 1) {
			System.exit(0);
		}
	}

	private void mostrarInformacoesSobre() {
		new MensagemView("Sistema de Gestão Assistec", 10);
	}

	private void configurarPerfilUsuario() {
		ArrayList<String> listaPerfil = new ArrayList<>();
		if ("Admin".equalsIgnoreCase(perfil)) {
			listaPerfil.add("MenuRelatorio");
			listaPerfil.add("MenuCadastro");
		}
		principalView.configurarPerfilUsuario(login, listaPerfil);
	}

}