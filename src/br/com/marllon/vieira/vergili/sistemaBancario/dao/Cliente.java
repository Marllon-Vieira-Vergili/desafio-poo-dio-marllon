package br.com.marllon.vieira.vergili.sistemaBancario.dao;


import java.util.Objects;

/**
 * Modelo de classe do Cliente do banco.
 *
 * @Atributos String com o nome do Cliente, e CPF
 *
 * @Getters e @Setters dos atributos (Modificadores de acesso)
 *
 *
 * @Construtores com parâmetros e sem parâmetros
 *
 *
 * @Métodos Equals pra comparação dos valores e @HashCode.
 *
 *
 *
 * */

public class Cliente {

    //Atributos com acesso private
    private String nomeCliente;
    private String cpf;

    //===========================================================================


    /*
    * Construtores do método, sem parâmetros, e com parâmetros para instâncias
    * */
    public Cliente(){

    }

    public Cliente(String nomeCliente, String cpf){
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
    }

//===========================================================================



    //Getters e setters para acesso e manipulação dos atributos

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

//===========================================================================


    /**
     * Métodos equals ajustado, para comparação de um objeto com o outro.
     * @Override para sobrescrever o método.
     *
     * recebe como parâmetro o
     * @Param object, e recebe como
     * @Return um valor booleano, comparando se
     *o nome está vinculado certinho a aquele cpf
     *
     * */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cliente cliente)) return false;
        return Objects.equals(nomeCliente, cliente.nomeCliente) && Objects.equals(cpf, cliente.cpf);
    }

    /**
     * @Override para sobrescrever o método
     *
     * Gerar HashCode ùnico para cada objeto "Cliente" criado, com seu valor e cpf
     * @Return um valor int(Inteiro)
     *
     * */
    @Override
    public int hashCode() {
        return Objects.hash(nomeCliente, cpf);
    }


    /**
     * @Override para sobrescrever o método
     *
     * Gerar um valor ToString
     * @Return String como resposta, para os valores do cliente.
     *
     * */
    @Override
    public String toString() {
        return "Cliente{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
