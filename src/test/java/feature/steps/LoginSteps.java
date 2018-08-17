package feature.steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import cucumber.api.java.pt.Então;

public class LoginSteps {		
	
	@Dado("^Que eu acessei o app portal brq com credenciais válida$")
	public void teste1() {
	    // Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Quando("^Eu solicitar reserva para a sala Arena da BRQ Boa Vista, localizada no (\\d+)° Andar para o dia (\\d+) de dezembro das (\\d+):(\\d+) as (\\d+):(\\d+)$")
	public void teste2(Integer arg1, Integer arg2, Integer arg3, Integer arg4, Integer arg5, Integer arg6) {   
		// Write code here that turns the phrase above into concrete actions
	    	throw new PendingException();
	}

	@Então("^A reserva deverá ser efetivada$")
	public void teste3() {
	// Write code here that turns the phrase above into concrete actions
	    	throw new PendingException();
	}

	@Dado("^Que eu acessei o portal brq com credenciais válidas$")
	public void teste4() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Quando("^Eu consultar reserva para o (\\d+)° Andar, na Sala Arena, com o nome do solicitante Paulo Lobo Neto$")
	public void teste5() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Então("^Deverá aparecer a reserva feita$")
	public void teste6() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^Que eu consultei uma reserva válida$")
	public void teste7() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Então("^Devo excluir a reserva$")
	public void teste8() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
