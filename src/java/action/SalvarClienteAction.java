package action;

import controle.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalvarClienteAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        OperacaoClienteSalvar salvarCliente = new OperacaoClienteSalvar();
        salvarCliente.realizarOperacao(request, response);
        
    }
    
}