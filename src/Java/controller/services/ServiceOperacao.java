package Java.controller.services;

import Java.controller.model.contas.Conta;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class ServiceOperacao {
    protected String saque;
    protected String deposito;
    protected String transferir;
    protected String extrato;

    public ServiceOperacao() {

    }

    public void atoOperacao() {
        this.saque = "saque";
        this.deposito = "deposito";
        this.transferir = "transferência";
        this.extrato = "extrato";
    }

    public void verboOperacao() {
        this.saque = "sacar";
        this.deposito = "depositar";
        this.transferir = "transferir";
        this.extrato = "imprimir extrato";
    }

    public void feitoOperacao() {
        this.saque = "sacou";
        this.deposito = "depositou";
        this.transferir = "transferiu";
        this.extrato = "imprimiu extrato";
    }

    public String executaOp(ServiceOperacao op, int opcao, String str) {
        if (opcao == 1) {
            if (str == "ato") {
                op.atoOperacao();
                str = op.saque;
            } else if (str == "verbo") {
                op.verboOperacao();
                str = op.saque;
            } else if (str == "feito") {
                op.feitoOperacao();
                str = op.saque;
            }
        }else if (opcao == 2) {
            if (str == "ato") {
                op.atoOperacao();
                str = op.deposito;
            } else if (str == "verbo") {
                op.verboOperacao();
                str = op.deposito;
            } else if (str == "feito") {
                op.feitoOperacao();
                str = op.deposito;
            }
        }else if (opcao == 3) {
            if (str == "ato") {
                op.atoOperacao();
                str = op.transferir;
            } else if (str == "verbo") {
                op.verboOperacao();
                str = op.transferir;
            } else if (str == "feito") {
                op.feitoOperacao();
                str = op.transferir;
            }
        }else if (opcao == 4) {
            if (str == "ato") {
                op.atoOperacao();
                str = op.extrato;
            } else if (str == "verbo") {
                op.verboOperacao();
                str = op.extrato;
            } else if (str == "feito") {
                op.feitoOperacao();
                str = op.extrato;
            }
        }
        return str;
    }

    public String formataValor(double valor) {
        String novoValor;
        DecimalFormat frmt = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        novoValor = frmt.format(valor);
        return novoValor;
    }

    public void selecionaMensagens(int id, ServiceLeitura novoLeitor, ServiceClientes lista, int opcao, ServiceOperacao oper) {
        System.out.println("Digite o valor da operação - " + oper.executaOp(oper, opcao, "ato") + ".");
        novoLeitor.verificaEntrada("Double", novoLeitor, lista);
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        novoLeitor.verificaEntrada("Int", novoLeitor, lista);
        while (novoLeitor.getLeitorInt() != 1 && novoLeitor.getLeitorInt() != 2) {
            System.out.println("Digite uma opção válida.");
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Conta Poupança");
            novoLeitor.verificaEntrada("Int", novoLeitor, lista);
        }
    }
    public void sucesso(ServiceOperacao oper, int opcao, ServiceLeitura novoLeitor, ServiceClientes lista, int index, String nome, double saldoRestante){
        Scanner pause = new Scanner(System.in);
        System.out.println("Parabéns " + lista.getListaDeClientes().get(index).getNome() + ".");
        System.out.println("Operação realizada com sucesso!");
        System.out.println("Você " + oper.executaOp(oper, opcao, "feito")  + " R$ " + formataValor(novoLeitor.getLeitorDouble()) + " Reais da sua " + nome + ".");
        System.out.println("Seu saldo atual é de: R$ " + formataValor(saldoRestante));
        System.out.print("---------------------------------------");
        System.out.print("\nDigite ENTER para continuar: ");
        pause.nextLine();

    }
}
