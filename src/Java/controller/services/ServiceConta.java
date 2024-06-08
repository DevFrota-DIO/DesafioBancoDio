package Java.controller.services;


public class ServiceConta {



    public void executaOperacao(int id, ServiceLeitura novoLeitor, ServiceClientes lista, int opcao) {
        int novoId = id;

        ServiceOperacao oper = new ServiceOperacao();

        oper.selecionaMensagens(id, novoLeitor, lista, opcao, oper);

        int index = 0;
        String nome = "";
        double saldoRestante = 0;
        for (int i = 0; i < lista.getListaDeClientes().size(); i++) {
            if (lista.getListaDeClientes().get(i).getIdCliente() == novoId) {
                index = i;
                if (novoLeitor.getLeitorInt() == 1) {
                    nome = "Conta Corrente";
                    if(opcao == 1) {
                        lista.getListaDeClientes().get(i).getCorrente().sacar(novoLeitor.getLeitorDouble());
                        saldoRestante = (lista.getListaDeClientes().get(index).getCorrente().getSaldo());
                    }else if(opcao == 2){
                        lista.getListaDeClientes().get(i).getCorrente().depositar(novoLeitor.getLeitorDouble());
                        saldoRestante = (lista.getListaDeClientes().get(index).getCorrente().getSaldo());
                    }else if(opcao == 3){
                        System.out.println("Informe o numero da contaCP de destino");
                        novoLeitor.verificaEntrada("Int", novoLeitor, lista);
                        lista.getListaDeClientes().get(i).getCorrente().transferir(novoLeitor.getLeitorDouble(), novoLeitor.getLeitorInt(), lista);
                        saldoRestante = (lista.getListaDeClientes().get(index).getCorrente().getSaldo());
                    }


                } else if (novoLeitor.getLeitorInt() == 2) {

                    nome = "Conta Poupança";
                    if(opcao == 1) {
                        lista.getListaDeClientes().get(i).getPoupanca().sacar(novoLeitor.getLeitorDouble());
                        saldoRestante = (lista.getListaDeClientes().get(index).getPoupanca().getSaldo());
                    }else if(opcao == 2){
                        lista.getListaDeClientes().get(i).getPoupanca().depositar(novoLeitor.getLeitorDouble());
                        saldoRestante = (lista.getListaDeClientes().get(index).getPoupanca().getSaldo());
                    }else if(opcao == 3){
                        System.out.println("Informe o numero da contaCP de destino");
                        novoLeitor.verificaEntrada("Int", novoLeitor, lista);
                        lista.getListaDeClientes().get(i).getPoupanca().transferir(novoLeitor.getLeitorDouble(), novoLeitor.getLeitorInt(), lista);
                        saldoRestante = (lista.getListaDeClientes().get(index).getPoupanca().getSaldo());
                    }

                }
            }



        }
        oper.sucesso(oper, opcao, novoLeitor, lista, index, nome, saldoRestante);

    }

}
