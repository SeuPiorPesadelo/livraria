package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AutorService {

	@Inject
	private AutorDao autorDao;

	//REQUIRED, como eh padrao, ao ser solicitado
	//sera aberta uma nova transacao
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adicionaAutor(Autor autor) {
		// aki poderia conter as regras de negócio
		autorDao.salva(autor);
	}

	public List<Autor> todosAutores() {
		// aki poderia conter as regras de negócio
		return autorDao.todosAutores();
	}
}
