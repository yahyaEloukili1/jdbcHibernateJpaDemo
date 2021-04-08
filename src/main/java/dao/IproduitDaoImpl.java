package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entitites.Produit;

@Repository
public class IproduitDaoImpl implements IProduitDao<Produit,Long> {
	private EntityManager entityManager;
	
	public IproduitDaoImpl() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("up_cat");
		entityManager = entityManagerFactory.createEntityManager();
		// TODO Auto-generated constructor stub
	}

	public List<Produit> findAll() {
		Query query = entityManager.createQuery("select p from Produit p");
		return query.getResultList();
	}

	
	public Produit save(Produit p) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
		 entityManager.persist(p); 
		 transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
		 return p;
	}

	@Override
	public List<Produit> findByDesignation(String mc) {
		Query query = entityManager.createQuery("select p from Produit p"
				+ " where p.designation like :x");
		query.setParameter("x", "%"+mc+"%");
		return query.getResultList();
	}

	@Override
	public void deleteById(Long id) {
		Produit p = entityManager.find(Produit.class, id);
		entityManager.remove(p);
		
	}

	@Override
	public void update(Produit p) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
		 entityManager.merge(p); 
		 transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
	
	}
		
	}

