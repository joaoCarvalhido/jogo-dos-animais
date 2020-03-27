package jogo.dao;

import java.util.List;

import jogo.entidade.Animal;

public interface AnimalDAO {

	public void novo(Animal animal);
	
	public Animal buscar(int id);
	
	public List<Animal> buscar();
	
}
