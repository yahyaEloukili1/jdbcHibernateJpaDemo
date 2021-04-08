package dao;

import java.util.List;

import entitites.Produit;

public interface IProduitDao<U,V> {
	public List<U> findAll();
	public U save(U u);
	public List<U> findByDesignation(String mc);
	public void deleteById(V id);
	public void update(U p);

}
