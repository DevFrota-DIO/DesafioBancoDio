package Java.controller.model.clientes;

import Java.controller.model.banco.Agencia;
import Java.controller.model.contas.ContaCorrente;
import Java.controller.model.contas.ContaPoupanca;
import Java.controller.services.ServiceLeitura;
import Java.controller.model.contas.Conta;
import Java.controller.services.ServiceClientes;
import Java.controller.services.ServiceConta;

import java.util.Scanner;

public class Cliente {
    private String nome;
    private String endereco;
    private Agencia agencia;
    private Conta conta;
    private ContaCorrente corrente;
    private ContaPoupanca poupanca;
    private int idCliente;

    private static int SEQUENCIAL = -1;

    public Cliente() {
        this.idCliente = SEQUENCIAL++;
        this.conta = new Conta();
        int num = getConta().getNumero();
        this.corrente = new ContaCorrente(num);
        this.poupanca = new ContaPoupanca(num);


    }

    public ContaCorrente getCorrente() {
        return corrente;
    }

    public void setCorrente(ContaCorrente corrente) {
        this.corrente = corrente;
    }

    public ContaPoupanca getPoupanca() {
        return poupanca;
    }

    public void setPoupanca(ContaPoupanca poupanca) {
        this.poupanca = poupanca;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getAgencia() {
        return agencia.toString();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void cadastrarCliente(Cliente novoCliente, ServiceClientes lista) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o Nome do Cliente:");
        novoCliente.setNome(leitor.nextLine());
        System.out.println("Digite o Endereço do Cliente:");
        novoCliente.setEndereco(leitor.nextLine());
        novoCliente.agencia = new Agencia();
        lista.setClientes(novoCliente, lista);
        System.out.println("Cliente cadastrado com sucesso!");

        int j = imprimeCliente(lista.getListaDeClientes().get(novoCliente.idCliente - 1));


    }


    public static int imprimeCliente(Cliente novo) {
        System.out.println("Anote as informações sobre sua contaCP, \npois você irá precisar caso queira atualizar seus dados.");
        System.out.println("ID de Cliente: " + novo.idCliente);
        System.out.println("Nome de Cliente: " + novo.nome);
        System.out.println("Endereço de Cliente: " + novo.endereco);
        System.out.println("Nome do Java.Banco: " + novo.agencia.getAgencia());
        System.out.println("Conta Tipo: " + novo.getCorrente().getCC());
        System.out.println("Conta Tipo: " + novo.getPoupanca().getCP() + "\n\n");
        return 1;
    }

    public static void atualizarCliente(int id, ServiceClientes lista, int opt) {

        ServiceLeitura novoLeitor = new ServiceLeitura();

        for (int i = 0; i < lista.getListaDeClientes().size(); i++) {
            if (lista.getListaDeClientes().get(i).idCliente == id) {
                if (opt == 1) {
                    System.out.println("Digite o novo nome \n");
                    novoLeitor.verificaEntrada("String", novoLeitor, lista);
                    lista.getListaDeClientes().get(i).setNome(novoLeitor.getLeitorString());
                } else if (opt == 2) {
                    System.out.println("Digite o novo Endereço \n");
                    novoLeitor.verificaEntrada("String", novoLeitor, lista);
                    lista.getListaDeClientes().get(i).setEndereco(novoLeitor.getLeitorString());
                }


            }
        }
    }
}
