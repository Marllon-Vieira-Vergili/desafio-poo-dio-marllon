import br.com.marllon.vieira.vergili.sistemaBancario.dao.Cliente;
import br.com.marllon.vieira.vergili.sistemaBancario.services.Conta;
import br.com.marllon.vieira.vergili.sistemaBancario.services.ServicosBanco;
import br.com.marllon.vieira.vergili.sistemaBancario.services.TipoDeConta;



/**
 * Classe principal para executar os métodos das outras classes e verificar com valores fixos se estão sendo chamados
 * ou não.. se está funcionando todos.
 * */
public class Main {
    public static void main(String[] args) {

        //Instanciando a classe de servicos do banco.
        ServicosBanco bancoServico = new ServicosBanco();

        //Instanciando 2 objetos clientes pra fazer teste
        Cliente cliente1 = new Cliente("Marllon", "123.456.789-00");
        Cliente cliente2 = new Cliente("João", "456.789.123-00");

        //Instanciando 2 objetos clientes pra fazer teste
        Conta conta1 = new Conta(1001, cliente1, TipoDeConta.CONTA_CORRENTE, 1000.0);
        Conta conta2 = new Conta(1002, cliente2, TipoDeConta.CONTA_POUPANCA, 500.0);

        //Chamando o banco serviço, pra pegar o método de criar conta, pro método de criar conta criar a conta
        //vinculada a conta 1 e a 2 tambem
        bancoServico.criarConta(conta1);
        bancoServico.criarConta(conta2);

        //Chamando o bancoServico pra executar estes métodos de depositar, sacar e transferir valor
        //das contas
        bancoServico.depositarValorNaConta(1001, 200.0);
        bancoServico.sacarValorNaConta(1002, 100.0);
        bancoServico.transferirValor(1001, 1002, 150.0);

        // Imprimindo os resultados
        System.out.println("=== Dados das contas ===");
        System.out.println(conta1);
        System.out.println(conta2);
        System.out.println("Saldos atualizados:");
        System.out.println("Conta " + conta1.getNumeroConta() + " (Cliente: " + cliente1.getNomeCliente() + "): R$" + conta1.getSaldo());
        System.out.println("Conta " + conta2.getNumeroConta() + " (Cliente: " + cliente2.getNomeCliente() + "): R$" + conta2.getSaldo());
    }
}
