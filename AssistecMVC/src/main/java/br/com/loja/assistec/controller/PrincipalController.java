package br.com.loja.assistec.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.loja.assistec.view.PrincipalView;

public class PrincipalController {

	private PrincipalView view;

	public PrincipalController(String usuario, String perfil) {
		this.view = new PrincipalView(usuario, perfil);
		configurarListeners();
		this.view.setVisible(true);
		this.view.setLocationRelativeTo(null);
	}

	private class principalListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if ("MenuSobreAction".equals(e.getActionCommand())) {
				sobre();
			} else if ("MenuSairAction".equals(e.getActionCommand())) {
				sair();
			} else if ("MenuUsuariosAction".equals(e.getActionCommand())) {
				listarUsuarios();
			}
		}
	}

	private void configurarListeners() {
		view.addPrincipalListener(new principalListener());

	}

	private void sobre() {
		view.mostrarMensagem("sistema de ordem de serviço", "Informação");
	}

	private void sair() {
		int Resposta = view.SairSistema();
		if (Resposta == 0) {
			System.exit(0);
		}
	}

	private void listarUsuarios() {
	}

}
