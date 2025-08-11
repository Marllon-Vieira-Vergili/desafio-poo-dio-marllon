package br.com.marllon.vieira.vergili.sistemaBancario.exceptions;

/**
 * Exceção customizada para SaldoNaoSuficiente
 *
 * @Return message como parâmetro, deixei customizado do jeito que é criado no java, na ide
 * para customização da mensagem na onde for chamada
 * */

public class SaldoNaoSuficienteExc extends RuntimeException {


    public SaldoNaoSuficienteExc(String message) {

     super(message);
    }
}
