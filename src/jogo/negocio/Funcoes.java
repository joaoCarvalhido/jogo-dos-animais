package jogo.negocio;

import java.util.List;

import jogo.dao.AnimalDAO;
import jogo.dao.AnimalDAOImpl;
import jogo.entidade.Animal;

public class Funcoes {
	
	private AnimalDAO animalDao = new AnimalDAOImpl();
	
	public List<Animal> listaDeAnimais(){
		return animalDao.buscar();
	}
	
	public Animal buscaAnimalAnterior() {
		if(listaDeAnimais().size() > 1) {
			int totalAnimais = listaDeAnimais().size();
			Animal animalAnterior = animalDao.buscar(totalAnimais-1);
			
			return animalAnterior;
		}
		return animalInicial();
	}
	
	public Animal buscaAnimalPosterior(Animal animal) {
		int posicaoAnimalAtual = listaDeAnimais().indexOf(animal);
		int totalAnimais = listaDeAnimais().size();
		if(totalAnimais > 0 && posicaoAnimalAtual < totalAnimais) {
			Animal animalPosterior = animalDao.buscar(posicaoAnimalAtual+1);
			return animalPosterior;
		}
		return animalInicial();
	}
	
	public int incrementaId() {
		int totalListaAnimais = listaDeAnimais().size();
		return totalListaAnimais + 1;
	}
	
	public void novoAnimal(String nome, String acao) {
		Animal animal = new Animal();
		animal.setId(incrementaId());
		animal.setNome(nome);
		animal.setAcao(acao);
		
		animalDao.novo(animal);
	}
	
	
	public String  animalDefault() {
		return "macaco";
	}
	
	public Animal animalInicial() {
		return animalDao.buscar(0);
	}


	public boolean verificaAcerto(int opcaoMenu) {
		if(opcaoMenu == 0) 
			return true;
		return false;
	}
	
	public Animal animalAtual(int posicao) {
		return animalDao.buscar(posicao);
	}

	
}
