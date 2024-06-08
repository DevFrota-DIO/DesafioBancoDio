package Java.controller.model.contas;

public class ContaPoupanca extends Conta{
	protected String identificadorCP;

	public ContaPoupanca(int conta) {
		this.identificadorCP = conta +"CP";

	}

	protected Object Agencias() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCP() {

		return "Conta Poupança: " + identificadorCP;
	}

}
