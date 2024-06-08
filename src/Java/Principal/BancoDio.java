package Java.Principal;


import java.io.IOException;
import Java.controller.model.clientes.Cliente;
import Java.controller.services.ServiceClientes;
import Java.view.config.ConfigMenu;
import Java.view.menus.Menus;
import Java.view.menus.TipoMenu;

public class BancoDio {

    public static void main(String[] args) throws InterruptedException, IOException {
        TipoMenu tipoMenu = TipoMenu.PRINCIPAL;
        ConfigMenu configMenu = new ConfigMenu();
        Menus menuAtivo = new Menus(tipoMenu);
        Cliente novoCliente = new Cliente();
        ServiceClientes novaLista = new ServiceClientes();
System.out.println("Ao criar sua contaCP você já inicia \ncom um saldo automático de R$ 100,00");

        menuAtivo = configMenu.telaDeMenu(menuAtivo, novoCliente, novaLista);

        if (!menuAtivo.nome.equalsIgnoreCase("Menu Sair") ) {
            while (menuAtivo.opcao != TipoMenu.SAIR) {

                menuAtivo = configMenu.telaDeMenu(menuAtivo, novoCliente, novaLista);


            }
        }

        System.out.println("Obrigado por Utilizar Nosso Sistema 2.\n");

    }


}
