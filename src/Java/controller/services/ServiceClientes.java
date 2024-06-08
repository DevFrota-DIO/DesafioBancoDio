package Java.controller.services;

import Java.controller.model.clientes.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceClientes extends Cliente {
    private final ArrayList<Cliente> listaDeClientes;

     public ServiceClientes() {
        this.listaDeClientes = new ArrayList<>();
    }


    public ArrayList<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setClientes(Cliente novoCliente, ServiceClientes lista) {
        int cont = 0;
        for (int i = 0; i < lista.size(); i++) {
            if(lista.listaDeClientes.get(i) != null && lista.listaDeClientes.get(i).getIdCliente() == novoCliente.getIdCliente()){
                cont +=1;
            }

        }
        if (cont == 0){
            lista.listaDeClientes.add(novoCliente);
        }


    }


    public void imprimeLista(ServiceClientes lista) {
        Scanner pause = new Scanner(System.in);
        System.out.println("\n\nLista de Clientes:");
        for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + "- " + lista.listaDeClientes.get(i).getNome()
                        + ", "+ lista.listaDeClientes.get(i).getEndereco() + ".");
            System.out.println("   ID de Cliente: " + lista.listaDeClientes.get(i).getIdCliente() + ".\n"
            + "   "+ lista.listaDeClientes.get(i).getAgencia() + "\n"
            + "   "+ lista.listaDeClientes.get(i).getCorrente().getCC() + ".\n"
            + "   "+ lista.listaDeClientes.get(i).getPoupanca().getCP() + ".\n");

            }
        System.out.print("---------------------------------------");
        System.out.print("\nDigite enter para continuar: ");
        pause.nextLine();

    }

    public int size() {
        return listaDeClientes.size();
    }

    public Object get(int index) {
        return listaDeClientes.get(index);
    }


    public String toString(ServiceClientes lista) {
        imprimeLista(lista);
        return null;
    }

}
