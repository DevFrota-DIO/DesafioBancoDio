package Java.controller.services;

import Java.controller.model.clientes.Cliente;
import Java.controller.model.contas.Conta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceLeitura {
    protected String leitorString;
    protected int leitorInt;
    private double leitorDouble;

    public int getLeitorInt() {
        return leitorInt;
    }

    public String getLeitorString() {
        return leitorString;
    }

    public double getLeitorDouble() {
        return leitorDouble;
    }

    public static String readString() {

        String str;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return str = reader.readLine();

        } catch (IOException e) {
            return str = "Falso";

        }
    }


    public static int readInt() {
        String str = readString();
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    public static double readDouble() {
        String str = readString();
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void verificaEntrada(String tipo, ServiceLeitura leitor, ServiceClientes lista) {

        String str;
        int inteiro;
        double real;
        if (tipo == "String") {
            str = readString();


            while (tipo == "Falso" || str.trim().length() == 0) {
                System.out.println("Digite um formato válido");
                str = readString();
            }
            leitor.leitorString = str;
        } else if (tipo == "Int") {
            inteiro = readInt();
            while (inteiro == 0) {
                System.out.println("Digite um valor válido");
                inteiro = readInt();

                if (inteiro != 0) {
                    while (inteiro != 0 && !(inteiro == verificaID(inteiro, lista))) {
                        System.out.println("Este ID de cliente não existe.");
                        System.out.println("Digite um ID válido");
                        inteiro = readInt();
                    }
                }

            }


            leitor.leitorInt = inteiro;
        } else if (tipo == "Double") {
            real = readDouble();
            while (real == 0) {
                System.out.println("Digite um valor válido");
                real = readDouble();

            }

            leitor.leitorDouble = real;
        }

    }


    public int verificaID(int inteiro, ServiceClientes lista) {
        int check = 0;

        for (Cliente cliente : lista.getListaDeClientes()) {
           if(cliente.getIdCliente() == inteiro);
           check = inteiro;

        }

        return check;
    }
}
