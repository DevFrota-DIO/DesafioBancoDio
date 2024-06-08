package Java.controller.model.contas;

public class ContaCorrente extends Conta{
	protected String identificadorCC;

	public ContaCorrente(int conta) {
		this.identificadorCC = conta +"CC";

	}

	public String getCC() {
		return "Conta Corrente: " + identificadorCC;
	}


}
