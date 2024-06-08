package Java.view.config;

import Java.controller.model.clientes.Cliente;
import Java.controller.services.ServiceClientes;
import Java.controller.services.ServiceConta;
import Java.controller.services.ServiceLeitura;
import Java.view.menus.Menus;
import Java.view.menus.TipoMenu;

import java.io.IOException;
import java.util.Scanner;

public class ConfigMenu {
    ServiceConta sConta = new ServiceConta();


    public Menus telaDeMenu(Menus menuAtual, Cliente novoCliente, ServiceClientes lista) throws InterruptedException, IOException {
        Scanner leitor = new Scanner(System.in);
        imprimeMenu(menuAtual);

        int valor;
        while (!(leitor.hasNextInt())) {
            imprimeMenu(menuAtual);
        }

        valor = leitor.nextInt();
        leitor.nextLine();

        int opcao = valor;


        //limpaTela();
        opcao = opcao(opcao, menuAtual);
        menuAtual = opcaoMenu(opcao, menuAtual, novoCliente, lista);

        opcao = 0;
        return menuAtual;
    }

    public void limpaTela() throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");

    }

    public Menus opcaoMenu(int opcao, Menus atualMenu, Cliente novoCliente, ServiceClientes lista) {
        Scanner leitor = new Scanner(System.in);

        String dados;
        if (atualMenu.nome == "Menu Principal") {
            if (opcao == 1) {
                atualMenu = new Menus(TipoMenu.CADASTRO);
            }else if (opcao == 2) {

                atualMenu = new Menus(TipoMenu.SAIR);
            }

        } else if (atualMenu.nome == "Menu Cadastro") {
            if (opcao == 1) {
                novoCliente = new Cliente();
                novoCliente.cadastrarCliente(novoCliente, lista);
                atualMenu = new Menus(TipoMenu.CADASTRO);

            }else if (opcao == 2) {
                atualMenu = new Menus(TipoMenu.CLIENTE);
            } else if (opcao == 3) {

                atualMenu = new Menus(TipoMenu.SAIR);

            }

        } else if (atualMenu.nome == "Menu Cliente") {
            if (opcao == 1) {
                System.out.println("Você vai gerenciar sua contaCP");
                atualMenu = new Menus(TipoMenu.CONTA);
            } else if (opcao == 2) {
                lista.imprimeLista(lista);
                atualMenu = new Menus(TipoMenu.CLIENTE);
            } else if (opcao == 3) {
                atualMenu = new Menus(TipoMenu.ATUALIZAR);

            } else if (opcao == 4) {
                atualMenu = new Menus(TipoMenu.CADASTRO);
            } else if (opcao == 5) {

                atualMenu = new Menus(TipoMenu.SAIR);

            }

        } else if (atualMenu.nome == "Menu Atualizar") {
            if (opcao == 1) {

                ServiceLeitura novoLeitor = new ServiceLeitura();
                System.out.println("Digite o ID do Cliente:");
                novoLeitor.verificaEntrada("Int", novoLeitor, lista);
                Cliente.atualizarCliente(novoLeitor.getLeitorInt(), lista, opcao);
                atualMenu = new Menus(TipoMenu.CLIENTE);
            } else if (opcao == 2) {
                ServiceLeitura novoLeitor = new ServiceLeitura();
                System.out.println("Digite o ID do Cliente:");
                novoLeitor.verificaEntrada("Int", novoLeitor, lista);
                Cliente.atualizarCliente(novoLeitor.getLeitorInt(), lista, opcao);
                atualMenu = new Menus(TipoMenu.CLIENTE);
            } else if (opcao == 3) {
                atualMenu = new Menus(TipoMenu.CADASTRO);

            } else if (opcao == 4) {
                atualMenu = new Menus(TipoMenu.SAIR);
            }

        } else if (atualMenu.nome == "Menu Conta") {
            if (opcao == 1) {
                ServiceLeitura novoLeitor = new ServiceLeitura();
                System.out.println("Digite o ID do Cliente.");
                novoLeitor.verificaEntrada("Int", novoLeitor, lista);
                sConta.executaOperacao(novoLeitor.getLeitorInt(), novoLeitor, lista, opcao);
                atualMenu = new Menus(TipoMenu.CONTA);
            } else if (opcao == 2) {
                ServiceLeitura novoLeitor = new ServiceLeitura();
                System.out.println("Digite o ID do Cliente.");
                novoLeitor.verificaEntrada("Int", novoLeitor, lista);
                sConta.executaOperacao(novoLeitor.getLeitorInt(), novoLeitor, lista, opcao);
                atualMenu = new Menus(TipoMenu.CONTA);
            } else if (opcao == 3) {
                ServiceLeitura novoLeitor = new ServiceLeitura();
                System.out.println("Digite o ID do Cliente.");
                novoLeitor.verificaEntrada("Int", novoLeitor, lista);
                sConta.executaOperacao(novoLeitor.getLeitorInt(), novoLeitor, lista, opcao);
                atualMenu = new Menus(TipoMenu.CONTA);

            } else if (opcao == 4) {
                Scanner pause = new Scanner(System.in);
                System.out.println(novoCliente.toString());
                pause.nextLine();
                atualMenu = new Menus(TipoMenu.CONTA);
            } else if (opcao == 5) {

                atualMenu = new Menus(TipoMenu.CLIENTE);

            } else if (opcao == 6) {

                atualMenu = new Menus(TipoMenu.SAIR);

            }

        }

        return atualMenu;

    }

    public void imprimeMenu(Menus imprime) {
        System.out.println("\nDigite o valor referente a opcão desejada.\n");
        System.out.println(imprime.nome);
        System.out.println("--------------------");

        for (int i = 0; i < imprime.menu.size(); i++) {
            System.out.println(imprime.menu.get(i));
        }
        if(imprime.nome == "Programa Finalizado")System.exit(0);

    }

    public int opcao(int opcao, Menus menuAtual) {

        Scanner leitor = new Scanner(System.in);
        int size = menuAtual.menu.size();
        while (opcao < (size / size) || opcao > size) {
            System.out.println("Opção Inválida.\n\n");
            imprimeMenu(menuAtual);
            opcao = leitor.nextInt();
            leitor.nextLine();
        }

        return opcao;

    }
}
