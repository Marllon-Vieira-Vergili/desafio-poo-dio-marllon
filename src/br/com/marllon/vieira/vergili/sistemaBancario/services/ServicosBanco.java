package br.com.marllon.vieira.vergili.sistemaBancario.services;
import br.com.marllon.vieira.vergili.sistemaBancario.exceptions.ContaNaoLocalizadaExc;
import br.com.marllon.vieira.vergili.sistemaBancario.exceptions.SaldoNaoSuficienteExc;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe Serviços banco - Vamos instanciar uma lista de Contas nesta classe,
 * para armazenar os valores das contas, herdando os métodos da
 * @Class LogicaSistemaBancario, e sendo implementados aqui
 *
 *
 * */
public class ServicosBanco extends LogicaSistemaBancario{


    //Atributo lista de Conta(classe) para armazenarmos os valores
    private List<Conta> contaDosClientes = new ArrayList<>();





    /**
     * Método de criar uma conta, passando como
     *
     * @Param os valores da classe conta
     *
     * Optei por realizar uma condição com booleano, pra criar uma variável
     * chamada "contaExistente", usando o método "anyMatch" da STREAM API,
     * na qual faz as condições se a conta1 que está recebendo o valor
     * vai ver se acha qualquer valor que dê match nos valores encontrados,
     *
     * se não existir... adicionar o objeto "conta" no array
     *
     * @throws  ContaNaoLocalizadaExc se não for localizado a conta criada.

     * */

    @Override
    public void criarConta(Conta conta) {

        boolean contaExistente = contaDosClientes.stream().anyMatch(conta1 ->
                conta1.getNumeroConta() == conta.getNumeroConta()  && conta1.getTipoConta() ==
                        conta.getTipoConta() && conta1.getSaldo() == conta.getSaldo());

        if(!contaExistente){
            //Array irá adicionar tudo da classe Conta
            contaDosClientes.add(conta);
        }

    }


    /**
     * Método de localizar uma conta criada, passando como
     *
     * @Param um valor inteiro com o número da conta. Utilizando a
     *
     * API Stream(Fluxo). Este fluxo, irá filtrar o array de contaDOsClientes e
     * encontrar o primeiro elemento. Se não localizar, retornar o
     * .orElseThrow que ja lanã a exceção, pois ele usa a classe Optionl pr evitar NullPointer
     *
     * @throws  ContaNaoLocalizadaExc se não for localizado a conta criada.

     * */

    private Conta localizarUmaConta(int numeroConta){

        return contaDosClientes
                .stream().filter(conta -> conta.getNumeroConta() == numeroConta)
                .findFirst()
                .orElseThrow(() -> new ContaNaoLocalizadaExc
                        ("Conta não localizada com número: " + numeroConta));
    }


    /**
     * Método depositar um valor na conta. Recebe como
     *
     * @Param um valor inteiro com o número da conta, e o valor a ser sacado.
     *
     * @throws  ContaNaoLocalizadaExc se não for localizado a conta criada.

     * */

    @Override
    public void depositarValorNaConta(int numeroConta, double valor) throws ContaNaoLocalizadaExc {

        boolean contaEncontrada = false;

        for (Conta contaLocalizada : contaDosClientes) {
            if (contaLocalizada.getNumeroConta() == numeroConta) {
                contaEncontrada = true;

                contaLocalizada.depositarValor(valor);
                break;
            }
        }
        //condição fora do FOR LOOP
        if(!contaEncontrada){
            throw new ContaNaoLocalizadaExc("Conta não localizada para fazer o saque!");

        }
    }


    /**
     * Método sacar um valor na conta. Recebe como
     *
     * @Param um valor inteiro com o número da conta, e o valor a ser sacado.
     *
     * @throws  ContaNaoLocalizadaExc se não for localizado a conta criada.
     * @throws SaldoNaoSuficienteExc tambem será retornado, se for identificado que o saldo é insuficiente

     * */

    @Override
    public void sacarValorNaConta(int numeroConta, double valor) throws ContaNaoLocalizadaExc, SaldoNaoSuficienteExc {

        //Condição que a conta nao foi encontrada
        boolean contaEncontrada = false;

        //Optei pela utilização do for convencional ao invés de Foreach. mais fácil a convenção
        for (Conta contaLocalizada : contaDosClientes) {
            if (contaLocalizada.getNumeroConta() == numeroConta) {
                contaEncontrada = true;

                //Se a conta localizada for encontrada dentro do array conta clientes, mas não tiver valor
                //Suficiente, retornar exception..
                if (contaLocalizada.getSaldo() < valor) {
                    throw new SaldoNaoSuficienteExc("Saldo insuficiente para saque!");
                }

                //Senão... a conta localizada chamará o método sacar valor, passando o valor no parametro
                //e break, sair do loop for.
                contaLocalizada.sacarValor(valor);
                break;
            }
        }
            //condição fora do FOR LOOP
            if(!contaEncontrada){
                throw new ContaNaoLocalizadaExc("Conta não localizada para fazer o saque!");

            }
    }

    /**
     * Método de verificar valor na conta
     *
     * @Param recebe como valor o número da conta que deverá ser informado.
     *
     * @throws  ContaNaoLocalizadaExc se não for localizado a conta criada.

     * */

    @Override
    public double verificarValorNaConta(int numeroConta) throws ContaNaoLocalizadaExc {

        //Fazendo um fluxo no array de contaDosClientes, filtrando a conta, tal que essa conta.get numero seja igual ao
        //Número da conta, e retornando em uma lista.
        List<Conta> contaLocalizada = contaDosClientes.stream()
                .filter(conta -> conta.getNumeroConta() == numeroConta).toList();

        if (!(contaLocalizada.isEmpty())){
            return contaLocalizada.getFirst().getSaldo();
        }else{
            throw new ContaNaoLocalizadaExc("Esta conta não foi localizada com esse número da conta informado");
        }

    }

    /**
     * Método transferir o valor de uma conta para outra.
     *
     * @Param recebe o valor da contaOrigem, o valor da contaDestino, e o valor a ser transferido..
     *
     * @throws  ContaNaoLocalizadaExc se não for localizado ambas as contas, tanto a conta de origem, quanto a conta de destino
     * @throws SaldoNaoSuficienteExc se for verificado na condição que a contaOrigem não possui saldo suficiente.
     * */

    @Override
    public void transferirValor(int contaOrigem, int contaDestino, double valor) throws ContaNaoLocalizadaExc, SaldoNaoSuficienteExc {

        //Encontrar a conta de Origem
        //Fazendo um fluxo no array de contaDosClientes, filtrando a conta, tal que essa conta.get numero seja igual ao
        //Número da conta, e retornando em uma lista. (Código aproveitado do método de cima)
        List<Conta> contaOrigemLocalizada = contaDosClientes.stream().filter(conta ->
                conta.getNumeroConta() == contaOrigem).toList();

        if (contaOrigemLocalizada.isEmpty()){
            throw new ContaNaoLocalizadaExc("Não foi localizada a conta de origem");
        }

        //Encontrar a conta de destino
        //Fazendo um fluxo no array de contaDosClientes, filtrando a conta, tal que essa conta.get numero seja igual ao
        //Número da conta, e retornando em uma lista. (Código aproveitado do método de cima)
        List<Conta> contaDestinoLocalizada = contaDosClientes.stream().filter(conta ->
                conta.getNumeroConta() == contaDestino).toList();

        if (contaDestinoLocalizada.isEmpty()){
            throw new ContaNaoLocalizadaExc("Não foi localizada a conta de destino");
        }

        //Verificar se a conta de origem possui saldo, e tambem se o valor é maior que o saldo da conta

        if (contaOrigemLocalizada.getFirst().getSaldo() <= 0 && valor > contaOrigemLocalizada.getFirst().getSaldo()){
            throw new SaldoNaoSuficienteExc("A conta de origem não possui saldo suficiente");
        }

        //Chamada dos métodos de sacar valor e depositar valor
        contaOrigemLocalizada.getFirst().sacarValor(valor);
        contaDestinoLocalizada.getFirst().depositarValor(valor);
        }
    }


