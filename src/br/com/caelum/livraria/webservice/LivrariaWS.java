package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

//diz ao container EJB q essa class é um WS
@WebService
@Stateless
public class LivrariaWS {
	
	//usamos livroDAO p/ delegar a pesquisa
	@Inject
	private LivroDao livroDao;

	//usando @WebParam deixa claro p/ o EJB q
	//queremos usar titulo como param no SOAP
	@WebResult(name="livros") //@WebResult dá nome ao elemento q retornará
	public List<Livro> getLivrosPeloNome(@WebParam(name="titulo") String n){
		System.out.println("LivroWS " + n);
		return livroDao.livrosPeloNome(n);
	}
}
