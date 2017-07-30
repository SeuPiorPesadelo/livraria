package br.com.caelum.livraria.exception;

import javax.ejb.ApplicationException;

//@ApplicationException (checked) padrao de rollback é false
//@ApplicationException(rollback=false)
@ApplicationException(rollback=true)
//public class LivrariaException extends RuntimeException {
public class LivrariaException extends Exception {

	
}
