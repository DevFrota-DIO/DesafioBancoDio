package Java.controller.model.contas;

import Java.controller.services.ServiceClientes;
import Java.controller.services.ServiceOperacao;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class Conta {
    private static int SEQUENCIAL = 100;
    private double saldoInicio = 100;
    private int numero;
    private double saldo;



    public Conta() {
        this.numero = SEQUENCIAL++;
        this.saldo = saldoInicio;

    }

    public int getSEQUENCIAL() {
        return SEQUENCIAL;
    }

    public static void setSEQUENCIAL(int sequencial) {
        SEQUENCIAL = sequencial;
    }

    public double getSaldoInicio() {
        return saldoInicio;
    }

    public void setSaldoInicio(double saldoInicio) {
        this.saldoInicio = saldoInicio;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valor) {

        this.saldo -= valor;
    }

    public void depositar(double valor) {
        this.saldo += valor;

    }

    public void transferir(double valor, int contaDestino, ServiceClientes lista) {
        this.sacar(valor);
        for (int i = 0; i < lista.getListaDeClientes().size(); i++) {
            if (lista.getListaDeClientes().get(i).getConta().getNumero() == contaDestino) {
                lista.getListaDeClientes().get(i).getConta().depositar(valor);
            }

        }

    }


    public double getSaldo() {
        return saldo;
    }
/*
    public void imprimirExtrato(int leitorInt, Leitura novoLeitor, ListaClientes lista, int opt) {

    }*/

    @Override
    public String toString() {
        ServiceOperacao serviceOperacao = new ServiceOperacao();
        return "CONTA \n" +
                "Numero = " + numero +
                ". \nSaldo = R$ " + serviceOperacao.formataValor(saldo) +
                '.' +
                "\n---------------------------------------" +
                "\nDigite ENTER para continuar: ";


    }


}
