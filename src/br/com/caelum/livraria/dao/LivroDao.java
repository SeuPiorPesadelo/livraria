package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@Stateless//isso virou um EJB
@TransactionManagement(TransactionManagementType.CONTAINER)//CONTAINER, esse eh o padrao, estah implicito
public class LivroDao {

	@PersistenceContext//EJB cuidarah das transacoes com JPA atraves do JTA
	private EntityManager entityManager;
	
	//REQUIRED, esse eh o padrao, estah implicito
	//Garante uma transacao quanto o metodo eh chamado, se nao
	//houver nenhuma, ele cria
	//MANDATORY, exige uma transacao rodando, senao, lanca uma exception
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salva(Livro livro) {
		entityManager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return entityManager.createQuery("select l from Livro l", Livro.class).getResultList();
	}
	
}
