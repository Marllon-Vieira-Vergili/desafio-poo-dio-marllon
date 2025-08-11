package br.com.marllon.vieira.vergili.sistemaBancario.services;


import br.com.marllon.vieira.vergili.sistemaBancario.exceptions.ContaNaoLocalizadaExc;
import br.com.marllon.vieira.vergili.sistemaBancario.exceptions.SaldoNaoSuficienteExc;

/**
 * Classe abstrata para armazenar as lógicas do sistema bancário, semelhante a uma interface.
 *
 * Porém, aqui, como iremos definir a mesma lógica para as outras classes, decidi e achei que
 * colocar a classe como abstrata seria a melhor opção. para extender na lógica do serviço de banco.
 *
 *  Semelhante a um CRUD com springboot
 */

public abstract class LogicaSistemaBancario {




    /**
     * Método abstrato que não terá retorno, ou seja, só será executado para criar uma conta, recebendo como
     * @Param a classe conta.
     *
     * */
    public abstract void criarConta(Conta conta);



    /**
     * Método abstrato que não terá retorno, ou seja, só será executado para depositar um valor na conta, recebendo como
     * @Param int numeroConta, o valor double.
     *
     * @throws ContaNaoLocalizadaExc se não encontrar a conta para ser realizado o depósito.
     *
     * */
    public abstract void depositarValorNaConta(int numeroConta, double valor) throws ContaNaoLocalizadaExc;





    /**
     * Método abstrato que não terá retorno, ou seja, só será executado para sacar um valor na conta, recebendo como
     * @Param int numeroConta, o valor double.
     *
     * @throws ContaNaoLocalizadaExc se não encontrar a conta para ser realizado o depósito.
     * @throws SaldoNaoSuficienteExc se a conta não tiver saldo o suficiente.
     *
     * */
    public abstract void sacarValorNaConta(int numeroConta, double valor)
            throws ContaNaoLocalizadaExc, SaldoNaoSuficienteExc;





    /**
     * Método abstrato que retornará um valor double, mostrando o valor na conta.
     *
     * @Param passado o numeroConta
     *
     * deve retornar o valor impresso no console comm o valor exato da conta
     *
     * @throws ContaNaoLocalizadaExc se não encontrar a conta

     *
     * */
    public abstract double verificarValorNaConta(int numeroConta) throws ContaNaoLocalizadaExc;




    /**
     * Método abstrato que não terá retorno, ou seja, só será executado para transferir um valor de uma conta a outra, recebendo como
     * @Param o valor da conta de origem, um int para informar a conta de destino, e o valor a ser transferido.
     *
     * O método retornará 2 exceções, caso as mesmas não forem atendidas.
     *
     * @throws ContaNaoLocalizadaExc se não localizar a conta de origem ou destino
     * @throws  SaldoNaoSuficienteExc se a conta de origem não possuir saldo.
     * */
    public abstract void transferirValor(int contaOrigem, int contaDestino, double valor)
            throws ContaNaoLocalizadaExc, SaldoNaoSuficienteExc;

}
