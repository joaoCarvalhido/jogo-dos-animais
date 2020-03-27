package jogo.tela;

import javax.swing.JOptionPane;

public class Mensagem {
	
	private String titulo = "JoaoCarvalhido - Jogo";
	
	public int pensarAnimal() {
		sleep();
		String corpoMensagem = "Pense em um animal";
		return JOptionPane.showConfirmDialog(null, corpoMensagem, titulo, JOptionPane.OK_CANCEL_OPTION);
	}
	
	public int tentaAcertarAcaoAnimal(String acao) {
		sleep();
		String corpoMensagem = "O animal que você pensou\n" + acao + "?";
		return JOptionPane.showConfirmDialog(null, corpoMensagem, titulo, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	
	public int tentaAcertarNomeAnimal(String nome) {
		sleep();
		String corpoMensagem = "O animal que você pensou é\n" + nome + "?";
		return JOptionPane.showConfirmDialog(null, corpoMensagem, titulo, JOptionPane.YES_OPTION);
	}
	
	public String novoAnimalAcao(String nome, String nomeAnterior) {
		sleep();
		String corpoMensagem = String.format("O que um(a) %s faz que um(a) %s não?", nome, nomeAnterior);
		return JOptionPane.showInputDialog(null, corpoMensagem, titulo, JOptionPane.QUESTION_MESSAGE);
	}
	
	public String novoAnimalNome() {
		sleep();
		String corpoMensagem = "Qual animal você pensou?";
		return JOptionPane.showInputDialog(null, corpoMensagem, titulo, JOptionPane.QUESTION_MESSAGE);
	}
	
	public int acertei() {
		sleep();
		String corpoMensagem = "Eu acertei!!!";
		return JOptionPane.showConfirmDialog(null, corpoMensagem, titulo, JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public int obrigadoPorJogar() {
		sleep();
		String corpoMensagem = "Obrigado por jogar!!!";
		return JOptionPane.showConfirmDialog(null, corpoMensagem, titulo, JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public int erroInformeValor() {
		sleep();
		String corpoMensagem = "Informe um valor";
		return JOptionPane.showConfirmDialog(null, corpoMensagem, titulo, JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
	}
	
	private void sleep() {
		try { Thread.sleep (300); } catch (InterruptedException ex) {}
	}
	
}
