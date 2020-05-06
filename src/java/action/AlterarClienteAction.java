package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarClienteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        OperacaoClienteAlterar alterarCliente = new OperacaoClienteAlterar();
        alterarCliente.realizarOperacao(request, response);
        
    }
    
}