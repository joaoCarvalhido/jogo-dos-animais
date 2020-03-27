package jogo.dao;

import java.util.ArrayList;
import java.util.List;

import jogo.entidade.Animal;

public class AnimalDAOImpl implements AnimalDAO {
	
	private List<Animal> animais = new ArrayList<Animal>();
	
	public AnimalDAOImpl() {
		animalInicial();
	}

	@Override
	public void novo(Animal animal) {
		animais.add(animal);
		
	}

	@Override
	public Animal buscar(int id) {
		return animais.get(id);	
	}
	
	@Override
	public List<Animal> buscar() {
		return animais;
	}
	
	private void animalInicial() {
		Animal animal = new Animal();
		animal.setId(1);
		animal.setNome("tubarão");
		animal.setAcao("vive na água");
		novo(animal);
	}

}
