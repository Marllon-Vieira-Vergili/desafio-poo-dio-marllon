package br.com.marllon.vieira.vergili.sistemaBancario.exceptions;

/**
 * Exceção customizada para ContaNaoLocalizada
 *
 * @Return message como parâmetro, deixei customizado do jeito que é criado no java, na ide
 * para customização da mensagem na onde for chamada
 * */
public class ContaNaoLocalizadaExc extends RuntimeException {

    public ContaNaoLocalizadaExc(String message) {
        super(message);
    }
}
