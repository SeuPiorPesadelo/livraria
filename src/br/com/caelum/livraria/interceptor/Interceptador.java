package br.com.caelum.livraria.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Interceptador {

	// @AroundInvoke diz p/ o EJBContainer q esse metodo é um interceptador
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		long tempoInicial = System.currentTimeMillis();

		// InvocationContext dah o poder de chamar o metodo em
		// uso dentro desta classe
		Object o = context.proceed();// prossegue com o metodo interceptado

		// pega o nome do metodo
		String metodo = context.getMethod().getName();
		// pega o nome da classe
		String classe = context.getTarget().getClass().getSimpleName();

		long tempoAtual = System.currentTimeMillis();
		System.out.println(
				"Tempo gasto " + (tempoAtual - tempoInicial) + "ms no metodo: " + metodo + " da classe: " + classe);
		return o;
	}
}
