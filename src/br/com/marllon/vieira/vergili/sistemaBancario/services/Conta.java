package br.com.marllon.vieira.vergili.sistemaBancario.services;
import br.com.marllon.vieira.vergili.sistemaBancario.dao.Cliente;

/**
 * Classe do modelo Contas
 *
 * @Atributos numeroConta(String), novoCliente(Classe Cliente), tipoConta(ENUM), saldo(double)
 *
 * @Construtores Com parâmetros e sem parâmetros para instância
 *
 * */


public class Conta {

    private String numeroConta;
    private Cliente novoCLiente;
    private TipoDeConta tipoConta;
    private double saldo;


    /**
     * Construtores para instanciar o objeto
     * Com parâmetros, e sem parâmetros.
     * */
    public Conta(){}

    public Conta(String numeroConta, Cliente novoCLiente,
                 TipoDeConta tipoConta, double saldo) {

        this.numeroConta = numeroConta;
        this.novoCLiente = novoCLiente;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }


    /*Métodos Getter e setter*/
    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getNovoCLiente() {
        return novoCLiente;
    }

    public void setNovoCLiente(Cliente novoCLiente) {
        this.novoCLiente = novoCLiente;
    }

    public TipoDeConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoDeConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    /***
     *Método Depositar valor, já incluso na Classe Conta, pois a conta
     * ja é responsável por gerenciar estes cálculos
     *
     * void não tem return... só executa a tarefa
     * @Param um valor para depósito.
     * adiciona o valor no atributo saldo
     *
     * */
    public void depositarValor(double valor){
        saldo = saldo + valor;
    }

    /***
     *Método sacar um valor, já incluso na Classe Conta, pois a conta
     * ja é responsável por gerenciar estes cálculos
     *
     * void não tem return... só executa a tarefa
     * @Param um valor para saque.
     * remove um valor no atributo saldo
     *
     * */
    public void sacarValor(double valor){
        saldo = saldo - valor;
    }

    /***
     *Método Sobrepondo outros com @Override
     *para imprimir os dados atualizados no console
     *
     * @return Array de conta, com seus atributos
     * numeroConta
     * novoCLiente
     * tipoConta
     * Saldo
     * */
    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta='" + numeroConta + '\'' +
                ", novoCLiente=" + novoCLiente +
                ", tipoConta=" + tipoConta +
                ", saldo=" + saldo +
                '}';
    }
}
