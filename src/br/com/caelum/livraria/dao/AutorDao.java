package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless//isso virou um EJB
public class AutorDao {
	
	//EJB cuidarah das transacoes com JPA
	//atraves do JTA
	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct//quando alguem chama esse EJB, o PostConstruct
	//entra em acao, soh eh criado um.
	void aposCriacao(){
		System.out.println("AutorDao foi criado!!!");
	}
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salva(Autor autor) {
		entityManager.persist(autor);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Autor> todosAutores() {
		return entityManager
				.createQuery("select a from Autor a", Autor.class)
				.getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.entityManager.find(Autor.class, autorId);
		return autor;
	}
}
