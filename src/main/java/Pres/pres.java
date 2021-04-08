package Pres;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import dao.IProduitDao;
import dao.IproduitDaoImpl;
import entitites.Produit;

public class pres {

	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				"dao");
		IProduitDao produitdao = context.getBean(IProduitDao.class);
		Produit p = new Produit();
		//produitdao.deleteById(1L);
		p.setDesignation("daraja");
		p.setPrix(3000);
		p.setQuantite(3);
		Produit ps = (Produit) produitdao.save(p);
		List<Produit> produits = new ArrayList<Produit>();
		
		produits = produitdao.findByDesignation("a");
		produits.forEach(pr->{
			System.out.println(pr);
		});
		Produit p2 = new Produit();
		p2.setId(2L);
		p2.setDesignation("dar");
		p2.setPrix(3000);
		p2.setQuantite(2);
		produitdao.update(p2);

	}

}
