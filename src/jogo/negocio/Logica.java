package jogo.negocio;

import jogo.entidade.Animal;
import jogo.tela.Mensagem;

public class Logica {

	private Funcoes funcao = new Funcoes();
	private Mensagem mensagem = new Mensagem();

	public void comecaJogo() {
		menuRecursivo();
	}
	
	private boolean menuRecursivo() {
		
		int opcaoMenu = mensagem.pensarAnimal();
		
		if(naoPararMenuRecursivo(opcaoMenu)) {
			
			Animal animalAtual = funcao.animalInicial();
			descobrirAnimal(animalAtual, opcaoMenu);
			menuRecursivo();
			return true;
		}
		return false;	
	}
	
	private void descobrirAnimal(Animal animalAtual, int opcaoMenu) {
		
		// Descobrir animal com base na acao
		opcaoMenu = mensagem.tentaAcertarAcaoAnimal(animalAtual.getAcao());
		if (funcao.verificaAcerto(opcaoMenu)) {
			
			// Descobrir nome com base na acao
			opcaoMenu = mensagem.tentaAcertarNomeAnimal(animalAtual.getNome());
			
			if (funcao.verificaAcerto(opcaoMenu))
				mensagem.acertei();
			else
				novoAnimal();
			
		// Varre a lista de animais, se nao achar nada, ou é macaco ou cadastra um novo animal
		} else if (funcao.listaDeAnimais().size() > 1 && funcao.listaDeAnimais().size() > funcao.listaDeAnimais().indexOf(animalAtual)+ 1) {
				animalAtual = funcao.buscaAnimalPosterior(animalAtual);
				descobrirAnimal(animalAtual, opcaoMenu);
			}else {
				opcaoMenu = mensagem.tentaAcertarNomeAnimal(funcao.animalDefault());
				if (funcao.verificaAcerto(opcaoMenu))
					mensagem.acertei();
				else
				novoAnimal();
		}
	}
	

	private void novoAnimal() {
		String novoAnimalNome = mensagemNula(mensagem.novoAnimalNome());
		String novoAnimalAcao = mensagemNula(mensagem.novoAnimalAcao(novoAnimalNome, funcao.buscaAnimalAnterior().getNome()));

		funcao.novoAnimal(novoAnimalNome, novoAnimalAcao);
		menuRecursivo();
	}

	// Valida informacoes do animal
	private String mensagemNula(String string) {
		while (string == null || string.isEmpty()) {
			mensagem.erroInformeValor();
			novoAnimal();
		}
		return string;
	}
	
	private boolean naoPararMenuRecursivo(int continuar){
		if(continuar == 2) {
			obrigadoPorJogar();
			return false;
		}
		return true;
	}
	
	public int obrigadoPorJogar() {
		return mensagem.obrigadoPorJogar();
	}
	
}
